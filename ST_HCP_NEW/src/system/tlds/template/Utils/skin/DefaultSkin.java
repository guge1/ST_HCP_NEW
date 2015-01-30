package system.tlds.template.Utils.skin;


import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

public class DefaultSkin
  implements Skin, Serializable
{
  private DefaultSkinCfg cfg;
  private String rootUrl;

  public DefaultSkin(HttpServletRequest request, DefaultSkinCfg cfg)
  {
    this.cfg = cfg;
    StringBuffer sb = new StringBuffer();
    sb.append(request.getScheme());
    sb.append("://");
    sb.append(request.getServerName());
    sb.append(":");
    sb.append(request.getServerPort());
    sb.append(request.getContextPath());
    this.rootUrl = sb.toString();
  }

  public String getImage(String imgName)
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    sb.append(this.cfg.getImgDir());
    sb.append("/");
    sb.append(imgName);
    return sb.toString();
  }

  public String getJS(String jsName)
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    sb.append(this.cfg.getJsDir());
    sb.append("/");
    sb.append(jsName);
    return sb.toString();
  }

  public String getCSS(String cssName)
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    sb.append(this.cfg.getCssDir());
    sb.append("/");
    sb.append(cssName);
    return sb.toString();
  }

  public String getSkinPath()
  {
    return this.rootUrl + "/" + this.cfg.getDir();
  }

  public String getRes(String key, String name)
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    sb.append(this.cfg.getDir());
    sb.append("/");
    sb.append(key);
    sb.append("/");
    sb.append(name);
    return sb.toString();
  }

  public String getCSSPath()
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    sb.append(this.cfg.getCssDir());
    return sb.toString();
  }

  public String getJSPath()
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    sb.append(this.cfg.getJsDir());
    return sb.toString();
  }

  public String getImagePath()
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    sb.append(this.cfg.getImgDir());
    return sb.toString();
  }

  public String getRootUrl()
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    return sb.toString();
  }

  public String getMsgJS(String jsName)
  {
    StringBuffer sb = new StringBuffer();
    sb.append(this.rootUrl);
    sb.append("/");
    sb.append(this.cfg.getJsDir());
    sb.append("/");
    sb.append(this.cfg.getMsgJsDir());
    sb.append("/");
    sb.append(jsName);
    return sb.toString();
  }
}
