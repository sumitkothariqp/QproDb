package qpro.command;

import qpro.cache.MetaCacheService;
import qpro.meta.TableMeta;
import qpro.util.StringUtil;

import java.util.List;

public class DropCommand implements CommandInterface {

    public boolean validate(String query) {
        {
            List<String> q1= StringUtil.splitString(query,"// ");
            String tableName=q1.get(2);

            int splitCommandSize=q1.size();
            if(splitCommandSize<3){
                return false;
            }

            if (StringUtil.isEmpty(tableName) || !MetaCacheService.isTableExits(tableName)) {
                return false;
            }

        }
        return false;
    }

    public Object process(String query) {
        List<String> q1= StringUtil.splitString(query,"// ");
        String tableName=q1.get(2);
        TableMeta tableMeta = new TableMeta();
        MetaCacheService.dropTable(tableName);

        return null;
    }
}