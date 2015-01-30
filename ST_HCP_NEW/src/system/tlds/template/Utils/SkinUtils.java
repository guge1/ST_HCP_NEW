package system.tlds.template.Utils;


import java.util.Locale;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

import system.tlds.template.Utils.skin.DefaultSkin;
import system.tlds.template.Utils.skin.DefaultSkinCfg;
import system.tlds.template.Utils.skin.Skin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; 

public final class SkinUtils
{
  private static String key = "Key.Skin";

  private static DefaultSkinCfg defCfg = new DefaultSkinCfg();

  protected static Skin createDefaultForRequest(HttpServletRequest request)
  {
    Skin def = new DefaultSkin(request, defCfg);
    request.setAttribute(key, def);
    return def;
  }

  public static Skin getSkin(ServletRequest request)
  {
    Skin skin = (Skin)request.getAttribute(key);
    HttpServletRequest httpServletRequest = (HttpServletRequest)request;
    if (skin == null) {
      skin = (Skin)httpServletRequest.getSession(true).getAttribute(key);
    }
    return ((skin != null) ? skin : createDefaultForRequest(httpServletRequest));
  }

  public static String getImage(ServletRequest request, String imgName)
  {
    return getSkin(request).getImage(imgName);
  }

  public static String getJS(ServletRequest request, String jsName)
  {
    return getSkin(request).getJS(jsName);
  }

  public static String getCSS(ServletRequest request, String cssName)
  {
    return getSkin(request).getCSS(cssName);
  }

  public static String getSkinPath(ServletRequest request) {
    return getSkin(request).getSkinPath();
  }

  public static String getImagePath(ServletRequest request) {
    return getSkin(request).getImagePath();
  }

  public static String getJsPath(ServletRequest request) {
    return getSkin(request).getJSPath();
  }

  public static String getCssPath(ServletRequest request) {
    return getSkin(request).getCSSPath();
  }

  public static String getRootUrl(ServletRequest request) {
    return getSkin(request).getRootUrl();
  }

  public static String importJavaScriptFile(HttpServletRequest req, String src, String msgSrc, String defaultLocale)
  {
    Locale locale = (Locale)req.getSession().getAttribute("org.sotower.web.taglib.util.locale");
    if (locale == null) {
      locale = req.getLocale();
      req.getSession().setAttribute("org.sotower.web.taglib.util.locale", locale);
    }
    if (locale == null) {
      locale = Locale.getDefault();
      req.getSession().setAttribute("org.sotower.web.taglib.util.locale", locale);
    }

    String supportLocale = Global.getString("org.sotower.web.taglib.util.locale");
    String[] supportLocaleArray = (split(supportLocale, ",") == null) ? new String[0] : 
      split(supportLocale, ",");
    boolean supported = false;
    for (int i = 0; i < supportLocaleArray.length; ++i) {
      if (supportLocaleArray[i].equals(locale.toString())) {
        supported = true;
        break;
      }
    }
    StringBuffer jsMsgPath = new StringBuffer("");
    src = (src == null) ? "" : src;
    if ((msgSrc == null) || ("".equals(msgSrc)) || ("null".equals(msgSrc))) {
      if (src.indexOf(".") != -1)
        jsMsgPath.append(src.subSequence(0, src.lastIndexOf(".")));
      if (supported) {
        jsMsgPath.append("_");
        jsMsgPath.append(locale.toString());
      } else if ((defaultLocale != null) && ("".equals(defaultLocale)) && 
        ("null".equals(defaultLocale))) {
        jsMsgPath.append("_");
        jsMsgPath.append(defaultLocale);
      } else {
        jsMsgPath.append("_");
        jsMsgPath.append(Locale.CHINA.toString());
      }
    }
    else if (msgSrc.indexOf(".") != -1) {
      jsMsgPath.append(msgSrc.subSequence(0, msgSrc.lastIndexOf(".")));
    } else {
      jsMsgPath.append(msgSrc);
    }
    jsMsgPath.append(".js");

    String path1 = getSkin(req).getJS(src);
    String path2 = getSkin(req).getMsgJS(jsMsgPath.toString());
    StringBuffer returnValue = new StringBuffer("");
    returnValue.append("<script language='javascript' src='" + path2 + 
      "'></script>\n");
    returnValue.append("<script language='javascript' src='" + path1 + 
      "'></script>\n");
    return returnValue.toString();
  }

  public static String importCssFile(HttpServletRequest request, String src) {
    return getSkin(request).getRootUrl();
  }

  public static String importImgFile(HttpServletRequest request, String src) {
    return getSkin(request).getRootUrl();
  }
  
  
  public static String[] split(String str, String separatorChars)
  {
    return split(str, separatorChars, -1);
  }

  public static String[] split(String str, char separatorChar)
  {
    if (str == null) {
      return null;
    }
    int len = str.length();
    if (len == 0) {
      return new String[0];
    }
    List list = new ArrayList();
    int i = 0; int start = 0;
    boolean match = false;
    while (i < len)
      if (str.charAt(i) == separatorChar) {
        if (match) {
          list.add(str.substring(start, i));
          match = false;
        }
        start = ++i;
      }
      else {
        match = true;
        ++i;
      }
    if (match) {
      list.add(str.substring(start, i));
    }
    return ((String[])list.toArray(new String[list.size()]));
  }
  

  public static String[] split(String str, String separatorChars, int max)
  {
    if (str == null) {
      return null;
    }
    int len = str.length();
    if (len == 0) {
      return new String[0];
    }
    List list = new ArrayList();
    int sizePlus1 = 1;
    int i = 0; int start = 0;
    boolean match = false;
    if (separatorChars == null)
    {
      while (i < len)
        if (Character.isWhitespace(str.charAt(i))) {
          if (match) {
            if (sizePlus1++ == max) {
              i = len;
            }
            list.add(str.substring(start, i));
            match = false;
          }
          start = ++i;
        }
        else {
          match = true;
          ++i;
        }
    } else if (separatorChars.length() == 1)
    {
      char sep = separatorChars.charAt(0);
      while (i < len)
        if (str.charAt(i) == sep) {
          if (match) {
            if (sizePlus1++ == max) {
              i = len;
            }
            list.add(str.substring(start, i));
            match = false;
          }
          start = ++i;
        }
        else {
          match = true;
          ++i;
        }
    }
    else {
      do
        if (separatorChars.indexOf(str.charAt(i)) >= 0) {
          if (match) {
            if (sizePlus1++ == max) {
              i = len;
            }
            list.add(str.substring(start, i));
            match = false;
          }
          start = ++i;
        }
        else {
          match = true;
          ++i;
        }
      while (i < len);
    }

    if (match) {
      list.add(str.substring(start, i));
    }
    return ((String[])list.toArray(new String[list.size()]));
  }

}