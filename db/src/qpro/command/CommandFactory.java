package qpro.command;

public class CommandFactory {
    public static final String CREATE_COMMAND = "create table";
    public static final String DROP_COMMAND = "drop table";
    public static final String SELECT_COMMAND = "select";
    public static final String INSERT_COMMAND = "insert into";
    public static final String DELETE_COMMAND = "delete from";
    public static final String SHOW_TABLES = "show tables";
    public static final String HELP_TABLES = "help";

    public static CommandInterface getCommand(String query) {
        if (query.contains(CREATE_COMMAND))
            return new CreateCommand();
        else if (query.contains(DROP_COMMAND))
            return new DropCommand();
        else if (query.contains(SELECT_COMMAND))
            return new SelectCommand();
        else if (query.contains(INSERT_COMMAND))
            return new InsertCommand();
        else if (query.contains(DELETE_COMMAND))
            return new DeleteCommand();
        else if (query.contains(SHOW_TABLES))
            return new ShowTablesCommand();
        else if (query.contains(HELP_TABLES))
            return new HelpCommand();
        return null;

    }
}
