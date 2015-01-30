package system.tlds;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

import system.tlds.template.Utils.SkinUtils;

public class SkinPathTag extends TagSupport
{
  private static final Log log = LogFactory.getLog(SkinPathTag.class);

  public int doStartTag() throws JspException
  {
    try {
      this.pageContext.getOut().print("ST_HCP_NEW");
        //SkinUtils.getSkinPath( (HttpServletRequest)this.pageContext.getRequest()));
    } catch (Exception e) {
      String message = "处理SkinPath-tag时出错";
      log.error(message, e);
      try {
        this.pageContext.getOut().print(message);
      } catch (IOException localIOException) {
      }
    }
    return 0;
  }
}
