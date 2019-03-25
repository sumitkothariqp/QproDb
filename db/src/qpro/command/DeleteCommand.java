package qpro.command;

import qpro.cache.MetaCacheService;
import qpro.util.StringUtil;

import java.util.List;

public class DeleteCommand implements CommandInterface {

    public boolean validate(String query) {
        List<String> q1 = StringUtil.splitString(query, " ");
        if (!MetaCacheService.isTableExits(q1.get(2))) {
            return false;
        }
        return true;
    }

    public Object process(String query) {
        List<String> q1 = StringUtil.splitString(query, " ");
        int id = 0;
        if (q1.size() > 2) {
            id = Integer.parseInt(q1.get(3));
        }
        System.out.println("Delete successfully : id " + id );
        //Delete from cache

        return null;
    }
}
