package com.qpro.cli;

import com.qpro.command.CommandFactory;
import com.qpro.command.CommandInterface;
import com.qpro.pojo.QueryStats;

public class CliProcessor {

    public void process(String query) {

        CommandInterface commandInterface = CommandFactory.getCommand(query);
        QueryStats stats = commandInterface.executeQuery(query);



    }
}
