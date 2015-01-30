package system.tlds.template.CommandFactory.Command;

import java.io.Serializable;

public abstract interface ICommand extends Serializable
{
  public static final String DOT = ".";
  public static final String GLOBALBEANID = "global.forward";
  public static final String SUCCESS = "success";
  public static final String NONE = "none";
  public static final String ERROR = "error";
  public static final String INPUT = "input";
  public static final String LOGIN = "login";

  public abstract void execute()
    throws Exception;
}