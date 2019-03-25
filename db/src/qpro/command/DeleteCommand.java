package qpro.command;

import qpro.cache.DataCacheService;
import qpro.cache.MetaCacheService;
import qpro.util.StringUtil;

import java.util.List;

public class DeleteCommand implements CommandInterface {

    public boolean validate(String query) {
        List<String> q1 = StringUtil.splitString(query, " ");
        if (q1.size() <= 3) {
            return false;
        }
        if (!MetaCacheService.isTableExist(q1.get(2))) {
            return false;
        }
        return true;
    }

    public Object process(String query) {
        List<String> q1 = StringUtil.splitString(query, " ");
        int id = 0;
        if (q1.size() > 3) {
            id = Integer.parseInt(q1.get(3));
        }
        System.out.println("Delete successfully : id " + id );

        String tableName = q1.get(2);
        DataCacheService.deleteRow(tableName, id);
        return null;
    }
}
