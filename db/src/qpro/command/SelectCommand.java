package qpro.command;

import qpro.cache.DataCacheService;
import qpro.cache.MetaCacheService;
import qpro.meta.ColumnMeta;
import qpro.meta.TableMeta;
import qpro.util.StringUtil;

import java.util.List;
import java.util.Map;

public class SelectCommand implements CommandInterface {
    TableMeta tableMeta = new TableMeta();

    public boolean validate(String query) {

        List<String> q1 = StringUtil.splitString(query, " ");
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
                if (!columns.equals(columnMeta.getName()) && !columns.equals("*")) {
                    return false;
                }
            }
        }

        return true;
    }

    public Object process(String query) {
        List<String> q1 = StringUtil.splitString(query, " ");
        String columns = q1.get(1);
        String tableName = q1.get(3);
        TableMeta tableMeta = MetaCacheService.getTableMeta(tableName);
        List<ColumnMeta> listofColumns = tableMeta.getColumns();

        if (columns.equals("*")) {
            listofColumns.stream().forEach(column -> System.out.print(column.getName() + "    "));
            for (ColumnMeta columnMeta : listofColumns) {
                List<Map<String, Object>> listOfData = DataCacheService.getAllRows(tableName);
                listOfData.forEach(item ->
                        item.forEach((k, v) -> System.out.print((String) v + "  ")
                        ));
            }
        } else {
            List<String> columnList = StringUtil.splitString(columns, ",");
            columnList.stream().forEach(column -> System.out.print(column + "    "));
            List<Map<String, Object>> listOfData = DataCacheService.getAllRows(tableName);
            listOfData.forEach(item -> {
                item.forEach((k, v) -> {
                    if (columns.equals(k))
                        System.out.print((String) v + "   ");
                });
                System.out.println();
            });
        }
        return null;
    }
}
