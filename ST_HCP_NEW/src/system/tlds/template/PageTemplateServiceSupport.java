package system.tlds.template;


import java.io.InputStream;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import system.util.XmlUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PageTemplateServiceSupport
  implements PageTemplateService, InitializingBean, ApplicationContextAware
{
  private static Log logger = LogFactory.getLog(PageTemplateServiceSupport.class);
  private ApplicationContext applicationContext = null;
  public static final String KEY = "key";
  public static final String VALUE = "value";
  public static final String DIRECT = "direct";
  public static final String SCREEN = "screen";
  public static final String SCREEN_NAME = "screen-name";
  public static final String SCREEN_TEMPLATE = "screen-template";
  public static final String LINK = "link";
  public static final String TEMPLATE = "template";
  private String template;
  private String jspPath;
  private String[] configFiles;
  private boolean isInitialized = false;
  private HashMap screensMap = new HashMap();

  public synchronized void init() {
    if (this.isInitialized) {
      return;
    }
    logger.info("init PageTemplateServiceSupport start");
    loadConfigMappings();
    this.isInitialized = true;
    logger.info("init PageTemplateServiceSupport finish");
  }

  public synchronized void destroy() {
    logger.info("destroy PageTemplateServiceSupport start");
    this.screensMap.clear();
    this.isInitialized = false;
    logger.info("destroy PageTemplateServiceSupport finish"); }

  private void loadConfigMappings() {
    for (int i = 0; i < this.configFiles.length; ++i) {
      if (logger.isInfoEnabled())
        logger.info("loading " + this.configFiles[i]);
      try
      {
        InputStream is = 
          getApplicationContext().getResource(this.configFiles[i]).getInputStream();
        Element root = XmlUtils.loadDocument(is);
        getScreens(root);
        if (logger.isInfoEnabled())
          logger.info("loaded " + this.configFiles[i] + " successed");
      }
      catch (Throwable e) {
        logger.error("loaded " + this.configFiles[i] + " failure", e);
      }
    }
  }

  private void getScreens(Element root)
  {
    String templateName = XmlUtils.getTagValue(root, "template");
    if ((templateName == null) || (templateName.equals(""))) {
      templateName = this.template;
    }

    NodeList list = root.getElementsByTagName("screen");
    for (int loop = 0; loop < list.getLength(); ++loop) {
      Node node = list.item(loop);
      if (node != null) {
        String screenName = XmlUtils.getSubTagValue(node, "screen-name");
        String screenTemplate = 
          XmlUtils.getSubTagValue(node, "screen-template");
        if ((screenTemplate == null) || (screenTemplate.equals(""))) {
          screenTemplate = templateName;
        }
        HashMap links = getLinks(node);
        Screen screen = new Screen(screenName, screenTemplate, links);
        if (this.screensMap.containsKey(screenName))
          logger.warn("*** 错误: Screen " + screenName + " 在配置文件里重复定义");
        else
          this.screensMap.put(screenName, screen);
      }
    }
  }

  private HashMap getLinks(Node node)
  {
    HashMap params = new HashMap();
    if (node != null) {
      NodeList children = node.getChildNodes();
      int innerLoop = 0;
      while (innerLoop < children.getLength())
      {
        Node child = children.item(innerLoop);
        if ((child != null) && 
          (child.getNodeName() != null) && 
          (child.getNodeName().equals("link")) && 
          (child instanceof Element)) {
          Element childElement = (Element)child;
          String key = childElement.getAttribute("key");
          String value = childElement.getAttribute("value");
          String directString = childElement.getAttribute("direct");
          boolean direct = false;
          if ((directString != null) && 
            (directString.equals("true"))) {
            direct = true;
          }
          if (!(params.containsKey(key)))
            params.put(key, new Link(key, value, direct));
          else
            logger.warn("*** 错误: Link " + key + " 重复定义");
        }
        ++innerLoop;
      }

    }

    return params;
  }

  public Screen getScreen(String scr) {
    if (!(this.isInitialized)) {
      init();
    }
    return ((Screen)this.screensMap.get(scr));
  }

  public Link getLink(String scrName, String linkKey) {
    return getScreen(scrName).getLink(linkKey);
  }

  public String getJspPath() {
    return this.jspPath;
  }

  public String getTemplate()
  {
    return this.template;
  }

  public void setJspPath(String string)
  {
    this.jspPath = string;
  }

  public void setTemplate(String string)
  {
    this.template = string;
  }

  public String[] getConfigFiles()
  {
    return this.configFiles;
  }

  public void setConfigFiles(String[] strings)
  {
    this.configFiles = strings;
  }

  public void setApplicationContext(ApplicationContext applicationContext)
    throws BeansException
  {
    this.applicationContext = applicationContext;
  }

  public ApplicationContext getApplicationContext()
  {
    return this.applicationContext;
  }

  public void afterPropertiesSet()
    throws Exception
  {
    if (getConfigFiles() == null)
      throw new RuntimeException("PageTemplateServiceSupport配置错误,属性configFiles不能为空");
  }
}