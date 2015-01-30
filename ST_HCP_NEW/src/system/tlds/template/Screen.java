package system.tlds.template;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Screen
  implements Serializable
{
  private String name;
  private String template;
  private Map linkHash = new HashMap();

  public Screen(String name, String template, HashMap linkHash) {
    this.name = name;
    this.template = template;
    this.linkHash = linkHash;
  }

  public String getTemplate() {
    return this.template;
  }

  public Map getLinkHash() {
    return this.linkHash;
  }

  public Link getLink(String key)
  {
    if (this.linkHash.containsKey(key)) {
      return ((Link)this.linkHash.get(key));
    }
    throw new RuntimeException("Î´¶¨ÒåµÄLINK:" + getName() + "." + key);
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String string)
  {
    this.name = string;
  }

  public void setTemplate(String string)
  {
    this.template = string;
  }

  public void setLinkHash(Map map)
  {
    this.linkHash = map;
  }

  public String toString() {
    return "[Screen: name=" + 
      this.name + 
      ", template=" + 
      this.template + 
      ",linkHash=" + 
      this.linkHash + 
      "]";
  }
}