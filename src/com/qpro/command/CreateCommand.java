public class CreateCommand implements CommandInterface {

    CreateCommand(String query) {
        if(isValidate(query)){
            process(query);
        }

    }

    public boolean isValidate(String query) {
        String[]rest;
        rest=query.split("create table");

        return false;
    }

    public void process(String query) {

    }
}
