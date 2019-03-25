package qpro.command;

import qpro.cache.MetaCacheService;
import qpro.meta.TableMeta;
import qpro.util.StringUtil;

import java.util.List;

public class SelectCommand implements CommandInterface {
    MetaCacheService metaCacheService = new MetaCacheService();
    TableMeta tableMeta = new TableMeta();

    public boolean validate(String query) {
        {

            List<String> q1 = StringUtil.splitString(query, "// ");
            String columns = q1.get(1);
            String syntax = q1.get(2);
            String tableName = q1.get(3);
            if (StringUtil.isEmpty(tableName) || !metaCacheService.isTableExits(tableName)) {
                return false;
            } else if (metaCacheService.isTableExits(tableName)) {
               /* if (metaCacheService.getTable) {

                }*/
            }
        }
        return true;
    }

    public Object process(String query) {

        return null;
    }
}
