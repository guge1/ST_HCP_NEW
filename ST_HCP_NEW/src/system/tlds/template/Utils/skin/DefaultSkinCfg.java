package system.tlds.template.Utils.skin;


import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

import system.tlds.template.Utils.Global;

public class DefaultSkinCfg
  implements Serializable
{
  private static Log log = LogFactory.getLog(DefaultSkinCfg.class);

  private String dir = "";

  private String imgDir = "images";

  private String jsDir = "js";

  private String cssDir = "css";

  private String msgJsDir = "messages";

  public DefaultSkinCfg()
  {
    String dirC = Global.getString("skin.default.dir");
    if (dirC != null) {
      this.dir = trimSlash(dirC);
    }
    log.debug("skin.default.dir:" + this.dir);

    String imgDirC = Global.getString("skin.default.images");
    if (imgDirC != null) {
      this.imgDir = trimSlash(imgDirC);
    }
    log.debug("skin.default.images:" + this.imgDir);

    String jsDirC = Global.getString("skin.default.js");
    if (jsDirC != null) {
      this.jsDir = trimSlash(jsDirC);
    }
    log.debug("skin.default.js:" + this.jsDir);

    String cssDirC = Global.getString("skin.default.css");
    if (cssDirC != null) {
      this.cssDir = trimSlash(cssDirC);
    }
    log.debug("skin.default.css:" + this.cssDir);
  }

  public void setCssDir(String string)
  {
    this.cssDir = trimSlash(string);
  }

  public void setImgDir(String string)
  {
    this.imgDir = trimSlash(string);
  }

  public void setJsDir(String string)
  {
    this.jsDir = trimSlash(string);
  }

  private String trimSlash(String s)
  {
    if (s != null) {
      if (s.startsWith("/")) {
        s = s.substring(1);
      }
      if (s.endsWith("/")) {
        s = s.substring(0, s.length() - 1);
      }
    }
    return s;
  }

  public String getCssDir()
  {
    return this.cssDir;
  }

  public String getImgDir()
  {
    return this.imgDir;
  }

  public String getJsDir()
  {
    return this.jsDir;
  }

  public String getDir()
  {
    return this.dir;
  }

  public void setDir(String string)
  {
    this.dir = string;
  }

  public String getMsgJsDir()
  {
    return this.msgJsDir;
  }

  public void setMsgJsDir(String msgJsDir)
  {
    this.msgJsDir = msgJsDir;
  }
}