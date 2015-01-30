package system.tlds.template;


public abstract interface PageTemplateService
{
  public abstract Screen getScreen(String paramString);

  public abstract Link getLink(String paramString1, String paramString2);

  public abstract String getJspPath();

  public abstract String getTemplate();
}