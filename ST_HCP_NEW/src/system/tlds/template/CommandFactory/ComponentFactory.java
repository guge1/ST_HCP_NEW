package system.tlds.template.CommandFactory;


import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentFactory
  implements ApplicationContextAware
{
  private static Log log = LogFactory.getLog(ComponentFactory.class);

  private static ApplicationContext applicationContext = null;

  public static Object getBean(String id)
  {
    return getApplicationContext().getBean(id);
  }

  public static synchronized void initApplicationContextInWebContext(ServletContext servletcontext)
  {
  }

  public static ApplicationContext getApplicationContext()
  {
    return applicationContext;
  }

  public static synchronized void initApplicationContextInClassPath()
  {
    log.info("初始化ApplicationContext开始");
    if (log.isInfoEnabled())
      log.info("从类路径加载conf/applicationContext.xml开始...");
    applicationContext = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
    if (log.isInfoEnabled())
      log.info("从类路径加载conf/applicationContext.xml完成");
    log.info("初始化ApplicationContext完成");
  }

  public static synchronized void initApplicationContextInDir(String dir)
  {
    log.info("初始化ApplicationContext开始");
    if (log.isInfoEnabled())
      log.info("从目录" + dir + "加载conf/applicationContext.xml开始...");
    if (log.isInfoEnabled())
      log.info("从目录" + dir + "加载conf/applicationContext.xml完成");
    log.info("初始化ApplicationContext完成");
  }

  public static synchronized void destroy()
  {
    applicationContext = null;
  }

  public void setApplicationContext(ApplicationContext context)
  {
    applicationContext = context;
  }
}