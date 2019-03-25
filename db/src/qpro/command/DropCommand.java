package qpro.command;

import qpro.cache.MetaCacheService;
import qpro.meta.TableMeta;
import qpro.util.StringUtil;

import java.util.List;

public class DropCommand implements CommandInterface {

    public boolean validate(String query) {
        {
            List<String> q1 = StringUtil.splitString(query, " ");
            if (q1.size() < 3) {
                return false;
            }
            String tableName = q1.get(2);
            if (StringUtil.isEmpty(tableName) || !MetaCacheService.isTableExist(tableName)) {
                return false;
            }

        }
        return true;
    }

    public Object process(String query) {
        List<String> q1 = StringUtil.splitString(query, " ");
        String tableName = q1.get(2);
        TableMeta tableMeta = new TableMeta();
        MetaCacheService.dropTable(tableName);

        return null;
    }
}