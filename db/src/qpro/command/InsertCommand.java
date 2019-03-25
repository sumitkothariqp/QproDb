package qpro.command;

import qpro.cache.DataCacheService;
import qpro.cache.MetaCacheService;
import qpro.meta.ColumnDataType;
import qpro.meta.ColumnMeta;
import qpro.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertCommand implements CommandInterface {
    public boolean validate(String query) {
        if (query.contains("(") && query.contains(")")) {
            return false;
        }
        List<String> q1 = StringUtil.splitString(query, "\\(");
        List<String> q2 = StringUtil.splitString(q1.get(0), "// ");
        String tableName = q2.get(2);
        if (StringUtil.isEmpty(tableName) || !MetaCacheService.isTableExits(tableName)) {
            return false;
        }
        String syntax = q2.get(3);
        if (!syntax.equals("values")) {
            return false;
        }

        List<String> q3 = StringUtil.splitString(q1.get(1), ",");
        if (!(q3.size() == MetaCacheService.getTableMeta(tableName).getColumns().size())) {
            return false;
        }
        List<ColumnMeta> columnsList = MetaCacheService.getTableMeta(tableName).getColumns();
        int i = 0;
        for (ColumnMeta columnMeta : columnsList) {
            if (ColumnDataType.getByType(q3.get(i)).equals(columnsList.get(i).getType())) {
                return false;
            }
            i++;
        }

        return true;
    }

    public Object process(String query) {
        List<String> q1 = StringUtil.splitString(query, "\\(");
        List<String> q2 = StringUtil.splitString(q1.get(0), "// ");
        List<String> q3 = StringUtil.splitString(q1.get(1), ",");
        String tableName = q2.get(2);
        Map<String, Object> map = new HashMap<String, Object>();
        List<ColumnMeta> columnsList = MetaCacheService.getTableMeta(tableName).getColumns();
        int i = 0;
        for (ColumnMeta columnMeta : columnsList) {
            map.put(columnMeta.getName(), q3.get(i));
            i++;
        }

        DataCacheService.insertRow(tableName, map);
        System.out.println("Data inserted Successfully");
        return null;
    }
}
