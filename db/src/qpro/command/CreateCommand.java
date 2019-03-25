package qpro.command;

import qpro.util.StringUtil;

import java.util.*;

public class CreateCommand implements CommandInterface {

    CreateCommand(String query) {
        if (isValidate(query)) {
            process(query);
        }

    }

    public boolean isValidate(String query) {
        List<String> q1 = StringUtil.splitString(query, "\\(");
        List<String> q2 = StringUtil.splitString(q1.get(0), "\\ ");
        String tableName = q2.get(2);
        if (StringUtil.isEmpty(tableName) || StringUtil.isNumeric(tableName)) {
            return false;
        }
        List<String>q3=StringUtil.splitString(q1.get(1).replace(")",""),",");
        List<String> q4=StringUtil.splitString(q3.get(0)," ");

        return true;
    }

    public Object process(String query) {

        return null;
    }
}
