package system.tlds.template.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public final class Global
{
  private static final String LOCATION = "../config/pro/global.properties";
  private static Properties properties;
  private static boolean hasLoad = false;

  private static Properties loadProperties(String location)
  {
    InputStream in = null;
    try
    {
      properties = new Properties();
      in =   getResourceAsStream(location);
      if (in != null) {
        properties.load(in);
        hasLoad = true;
      } else {
        throw new FileNotFoundException(location);
      }
      in.close();
    } catch (IOException e) {
      throw new RuntimeException("加载属性文件出错:" + location);
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    }
    return properties;
  }
  public static InputStream getResourceAsStream(String name)
  {
    if (name.startsWith("/")) {
      name = name.substring(1);
    }
    ClassLoader ccl = Thread.currentThread().getContextClassLoader();
    return ccl.getResourceAsStream(name);
  }
  public static String getString(String key)
  {
	  System.out.println(key);
    if (!(hasLoad)) {
      loadProperties(LOCATION);
    }
    return properties.getProperty(key);
  }

  public static List getList(String key)
  {
    if (!(hasLoad)) {
      loadProperties(LOCATION);
    }
    List list = new ArrayList();
    if ((key == null) || (key.equals("")))
      return list;
    Enumeration enum1 = properties.propertyNames();
    while (enum1.hasMoreElements()) {
      String item = (String)enum1.nextElement();
      if (item.indexOf(key) >= 0) {
        list.add(properties.getProperty(item));
      }
    }
    return list;
  }
}