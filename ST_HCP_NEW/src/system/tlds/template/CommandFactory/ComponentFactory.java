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
    log.info("��ʼ��ApplicationContext��ʼ");
    if (log.isInfoEnabled())
      log.info("����·������conf/applicationContext.xml��ʼ...");
    applicationContext = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
    if (log.isInfoEnabled())
      log.info("����·������conf/applicationContext.xml���");
    log.info("��ʼ��ApplicationContext���");
  }

  public static synchronized void initApplicationContextInDir(String dir)
  {
    log.info("��ʼ��ApplicationContext��ʼ");
    if (log.isInfoEnabled())
      log.info("��Ŀ¼" + dir + "����conf/applicationContext.xml��ʼ...");
    if (log.isInfoEnabled())
      log.info("��Ŀ¼" + dir + "����conf/applicationContext.xml���");
    log.info("��ʼ��ApplicationContext���");
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