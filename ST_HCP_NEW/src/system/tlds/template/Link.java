package system.tlds.template;

import java.io.Serializable;

public class Link
  implements Serializable
{
  private String key;
  private String value;
  private boolean direct;

  public Link(String key, String value, boolean direct)
  {
    this.key = key;
    this.value = value;
    this.direct = direct;
  }

  public boolean isDirect() {
    return this.direct;
  }

  public String getKey() {
    return this.key;
  }

  public String getValue() {
    return this.value;
  }

  public String toString() {
    return "[Link: key=" + 
      this.key + 
      ", value=" + 
      this.value + 
      ", direct=" + 
      this.direct + 
      "]";
  }
}
