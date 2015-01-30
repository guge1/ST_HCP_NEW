package system.tlds.template.CommandFactory.Command;


public class BaseRuntimeException extends RuntimeException
{
  Throwable nest = this;

  public BaseRuntimeException()
  {
  }

  public BaseRuntimeException(String message)
  {
    super(message);
  }

  public BaseRuntimeException(String message, Throwable t)
  {
    super(message);
    this.nest = t;
  }

  public BaseRuntimeException(Throwable t)
  {
    this.nest = t;
  }
}