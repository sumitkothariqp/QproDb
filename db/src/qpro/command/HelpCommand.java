package qpro.command;

public class HelpCommand implements CommandInterface {


    @Override
    public boolean isValidate(String query) {
        if (query.contains("help")) {
            return true;
        }
        return false;
    }

    @Override
    public Object process(String query) {

        if (query.contains("help")) {
            System.out.println("Commands: \n\t\t create;\n\t\t select;");
            System.out.println("check for help type: 'help create' \n 'help select'");
        } else if (query.contains("help create")) {
            System.out.println("create command: create table tablename (column_name column_type)");
        } else if (query.contains("help select")) {
            System.out.println("select command: select <*/column_name> from tablename ");
        }
        return null;

    }
}
