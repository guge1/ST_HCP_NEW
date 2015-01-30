package system.tlds.template.Utils.skin;

public abstract interface Skin
{
  public abstract String getImage(String paramString);

  public abstract String getJS(String paramString);

  public abstract String getCSS(String paramString);

  public abstract String getSkinPath();

  public abstract String getRes(String paramString1, String paramString2);

  public abstract String getCSSPath();

  public abstract String getJSPath();

  public abstract String getImagePath();

  public abstract String getRootUrl();

  public abstract String getMsgJS(String paramString);
}