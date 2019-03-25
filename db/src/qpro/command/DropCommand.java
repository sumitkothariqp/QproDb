package qpro.command;

public class DropCommand implements CommandInterface {
    DropCommand(String query) {
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