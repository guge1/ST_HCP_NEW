package system.tlds;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.sotower.util.Utils;
//import org.sotower.waf.ComponentFactory;

import system.tlds.template.Link;
import system.tlds.template.PageTemplateService;
import system.tlds.template.CommandFactory.ComponentFactory;

public class InsertTag extends TagSupport
{
  private static final Log log = LogFactory.getLog(InsertTag.class);
  private String link;
  private String pageTemplateServiceName = "pageTemplateService";

  public InsertTag() {
    this.link = null;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public int doStartTag() throws JspTagException {
    try {
      this.pageContext.getOut().flush();
    } catch (Exception e) {
      log.error(e);
    }
    return 0;
  }

  private PageTemplateService getTemplateService() {
    PageTemplateService templateService = (PageTemplateService)
      ComponentFactory.getBean(getPageTemplateServiceName());
    return templateService;
  }

  public int doEndTag() throws JspTagException
  {
    PageTemplateService templateService = getTemplateService();
    log.debug("------------- templateService === " + templateService);
    if (templateService == null) {
      throw new RuntimeException("在jsp上下文中没有找到" + 
        getPageTemplateServiceName());
    }
    String screenName = (String)this.pageContext.getRequest().getAttribute(
      "PageTemplate.CurrentScreen");
    Link linkRef = templateService.getLink(screenName, this.link);
    String jspPath = templateService.getJspPath();
    log.debug("------------- jspPath === " + jspPath);
    try {
      if (linkRef != null) {
        if (linkRef.isDirect()) {
          this.pageContext.getOut().print(linkRef.getValue());   return 6;
        }
        String value = linkRef.getValue();
        if (value != null)
        {
          if ((!(value.startsWith("/"))) && (!(jspPath.endsWith("/")))) {
            value = "/" + value;
          }
          if (!(jspPath.startsWith("/"))) {
            jspPath = "/" + jspPath;
          }
          value = jspPath + value;
          if (log.isInfoEnabled()) {
            log.info("insert link[" + value + "]");
          }

          this.pageContext.getRequest().getRequestDispatcher(value)
            .include(this.pageContext.getRequest(), 
            this.pageContext.getResponse());

            return 6;
        }

        this.pageContext.getOut().print(
          "LINK没有定义value属性:" + screenName + "." + this.link);

          return 6;
      }

      this.pageContext.getOut().print(
        "没有找到对应的LINK:" + screenName + "." + this.link);
    }
    catch (Throwable ex) {
      String message = "InsertTag:处理页面[" + screenName + "." + this.link + 
        "]时出错";
      log.error(message, ex);
      try {
        this.pageContext.getOut().print(message + ex + ex.getMessage());
      //  this.pageContext.getOut().print(Utils.stackTrace(ex));
      } catch (IOException localIOException) {
      }
    }
    label518: 
    	return 6;
  }

  public String getPageTemplateServiceName()
  {
    return this.pageTemplateServiceName;
  }

  public void setPageTemplateServiceName(String string)
  {
    this.pageTemplateServiceName = string;
  }
}