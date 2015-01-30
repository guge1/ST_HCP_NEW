package system.tlds.template.CommandFactory;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

import system.tlds.template.CommandFactory.Command.BaseRuntimeException;
import system.tlds.template.CommandFactory.Command.ICommand;
 

public class CommandFactory extends ComponentFactory
{
  private static Log log = LogFactory.getLog(CommandFactory.class);

  public static ICommand getCommand(String id)
  {
    try
    {
      return ((ICommand)getBean(id));
    } catch (Exception e) {
      log.error("没有对应的Command", e); 
      throw new BaseRuntimeException("没有对应的Command," + e.getMessage(), e);
    }
  }
}