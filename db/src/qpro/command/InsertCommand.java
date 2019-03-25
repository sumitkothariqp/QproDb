package qpro.command;

import qpro.util.StringUtil;

import java.util.List;

public class InsertCommand implements CommandInterface {
    public boolean validate(String query) {
        {
            List<String> q1= StringUtil.splitString(query,"\\(");
            List<String> q2=StringUtil.splitString(query,"\\ ");



        }
        return false;
    }

    public Object process(String query) {

        return null;
    }
}
