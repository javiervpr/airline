package commands;

import an.awesome.pipelinr.Command;
import core.BusinessRuleValidationException;

public interface CommandHandlerExceptions<C extends Command<R> ,R>  extends Command.Handler<C, R>  {

    R handle(C command);
}
