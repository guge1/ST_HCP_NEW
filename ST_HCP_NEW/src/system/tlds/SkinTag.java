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

public class SkinTag extends TagSupport
{
  private static final Log log = LogFactory.getLog(SkinTag.class);
  private String img;
  private String js;
  private String css;
  private String defValue;

  public void setDefValue(String defValue)
  {
    this.defValue = defValue;
  }

  public void setImg(String img)
  {
    this.img = img;
  }

  public void setJs(String js)
  {
    this.js = js;
  }
//  public  SkinUtils SkinUtils=new SkinUtils();
  
  public int doStartTag() throws JspException {
    try {
    	
      if (this.img != null) {
        this.pageContext.getOut().print(
          SkinUtils.getImage((HttpServletRequest)this.pageContext
          .getRequest(), this.img));

       // break label237:
            return 0;
      }

      if (this.js != null) {
        this.pageContext.getOut().print(
          SkinUtils.getJS(
          (HttpServletRequest)this.pageContext.getRequest(), this.js));

        //break label237:
            return 0;
      }

      if (this.css != null) {
        this.pageContext.getOut().print(
          SkinUtils.getCSS((HttpServletRequest)this.pageContext
          .getRequest(), this.css));

       // break label237:
        return 0;
      }

      this.pageContext.getOut().print(
        SkinUtils.getRootUrl((HttpServletRequest)this.pageContext
        .getRequest()));
    }
    catch (Exception e)
    {
      String message = "处理Skin-tag时出错, 参数: img='" + this.img + "', js='" + this.js + "'" + 
        ", defValue='" + this.defValue + "'";
      log.error(message, e);
      try {
        this.pageContext.getOut().print(message + e.getMessage());
      } catch (IOException localIOException) {
      }
    }
    label237: return 0;
  }

  public void release() {
    this.img = null;
    this.css = null;
    this.js = null;
    this.defValue = null;
  }

  public void setCss(String string)
  {
    this.css = string;
  }
}