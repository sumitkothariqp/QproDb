package qpro.cli;

import qpro.command.CommandFactory;
import qpro.command.CommandInterface;
import qpro.pojo.QueryStats;

public class CliProcessor {

    public static CliProcessor INSTANCE = new CliProcessor();

    public static CliProcessor getINSTANCE() {
        return INSTANCE;
    }

    public void process(String query) {

        CommandInterface commandInterface = CommandFactory.getCommand(query);
        QueryStats stats = commandInterface.executeQuery(query);




    }
}
