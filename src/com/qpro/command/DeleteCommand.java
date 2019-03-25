package com.qpro.command;

public class DeleteCommand implements CommandInterface {
    DeleteCommand(String query) {
        isValidate(query);
    }

    public boolean isValidate(String query) {
        {


        }
        return false;
    }

    public Object process(String query) {

        return null;
    }
}
