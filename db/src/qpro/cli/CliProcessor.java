package qpro.cli;

import qpro.cache.MetaCacheService;
import qpro.command.CommandFactory;
import qpro.command.CommandInterface;
import qpro.pojo.QueryStats;
import qpro.pojo.QueryStatus;

public class CliProcessor {

    public static CliProcessor INSTANCE = new CliProcessor();

    public static CliProcessor getINSTANCE() {
        return INSTANCE;
    }

    public void process(String query) {

        CommandInterface commandInterface = CommandFactory.getCommand(query);
        if (commandInterface == null) {
            System.out.println("invalid query");
        }
        QueryStats stats = commandInterface.executeQuery(query);
        if (QueryStatus.VALIDATION_FAIL.equals(stats.getQueryStatus())) {
            System.out.println("invalid query");
        }

    }
}
