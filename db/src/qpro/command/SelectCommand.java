package qpro.command;

import qpro.cache.MetaCacheService;
import qpro.meta.ColumnMeta;
import qpro.meta.TableMeta;
import qpro.util.StringUtil;

import java.util.List;

public class SelectCommand implements CommandInterface {
    TableMeta tableMeta = new TableMeta();

    public boolean validate(String query) {

        List<String> q1 = StringUtil.splitString(query, "// ");
        String columns = q1.get(1);
        String syntax = q1.get(2);
        String tableName = q1.get(3);
        if (StringUtil.isEmpty(syntax) || !syntax.equals("from")) {
            return false;
        }
        if (StringUtil.isEmpty(tableName) || !MetaCacheService.isTableExist(tableName)) {
            return false;
        } else if (MetaCacheService.isTableExist(tableName)) {
            List<ColumnMeta> allColumns = MetaCacheService.getTableMeta(tableName).getColumns();
            for (ColumnMeta columnMeta : allColumns) {
                if (!columns.equals(columnMeta.getName()) || !columns.equals("*")) {
                    return false;
                }
            }
        }

        return true;
    }

    public Object process(String query) {
        List<String> q1 = StringUtil.splitString(query, "// ");
        String columns = q1.get(1);
        String tableName = q1.get(3);
        if (columns.equals("*")) {
            TableMeta tableMeta = MetaCacheService.getTableMeta(tableName);
            List<ColumnMeta> listofColumns = tableMeta.getColumns();
            for (ColumnMeta columnMeta : listofColumns) {
                String columnName = columnMeta.getName();
                //display the column values.
            }
        } else {

        }
        return null;
    }
}
