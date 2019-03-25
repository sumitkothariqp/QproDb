package com.qpro.command;

public class CommandFactory {
    public static final String CREATE_COMMAND = "create table";
    public static final String DROP_COMMAND = "drop table";
    public static final String SELECT_COMMAND = "select";
    public static final String INSERT_COMMAND = "insert into";
    public static final String DELETE_COMMAND = "delete from";

    public static CommandInterface getCommand(String query) {
        if (query.contains(CREATE_COMMAND))
            return new CreateCommand(query);
        else if (query.contains(DROP_COMMAND))

            return new DropCommand(query);
        else if (query.contains(SELECT_COMMAND))

            return new SelectCommand(query);
        else if (query.contains(INSERT_COMMAND))

            return new InsertCommand(query);
        else if (query.contains(DELETE_COMMAND))

            return new DeleteCommand(query);


    }
}
