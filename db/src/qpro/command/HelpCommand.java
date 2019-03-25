package qpro.command;

public class HelpCommand implements CommandInterface {


    @Override
    public boolean validate(String query) {
        if (query.contains("help")) {
            return true;
        }
        return false;
    }

    @Override
    public Object process(String query) {

        if (query.contains("create")) {
            System.out.println("create command: create table tablename (column_name column_type)");
        } else if (query.contains("select")) {
            System.out.println("select command: select <*/column_name> from tablename ");
        } else if (query.contains("insert")) {
            System.out.println("insert command: insert into tablename values(column_value");
        } else if (query.contains("help")) {
            System.out.println("Commands: \n\t\t create;\n\t\t select;\n\t\t insert");
            System.out.println("check for help type: 'help create' \n 'help select'");
        }
        return null;

    }
}
