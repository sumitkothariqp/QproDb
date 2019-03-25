package qpro.command;

import qpro.meta.ColumnDataType;
import qpro.meta.TableMeta;
import qpro.util.StringUtil;
import qpro.meta.ColumnMeta;
import qpro.cache.MetaCacheService;

import java.util.ArrayList;
import java.util.List;

public class CreateCommand implements CommandInterface {

    public boolean validate(String query) {
        List<String> q1 = StringUtil.splitString(query, "\\(");
        List<String> q2 = StringUtil.splitString(q1.get(0), "\\ ");
        String tableName = q2.get(2);
        if (MetaCacheService.isTableExits(tableName)) {
            return false;
        }
        if (StringUtil.isEmpty(tableName) || StringUtil.isNumeric(tableName)) {
            return false;
        }
        List<String> q3 = StringUtil.splitString(q1.get(1).replace(")", ""), ",");
        for (int i = 0; i < q3.size(); i++) {
            List<String> q4 = StringUtil.splitString(q3.get(i), " ");
            if (StringUtil.isEmpty(q4.get(0)) || StringUtil.isNumeric(q4.get(0))) {
                return false;
            }

            if (ColumnDataType.getByType(q4.get(1)) == null) {
                return false;
            }
        }
        return true;
    }

    public Object process(String query) {
        TableMeta tableMeta = new TableMeta();
        List<String> q1 = StringUtil.splitString(query, "\\(");
        List<String> q2 = StringUtil.splitString(q1.get(0), "\\ ");
        String tableName = q2.get(2);
        tableMeta.setName(tableName);
        List<String> q3 = StringUtil.splitString(q1.get(1).replace(")", ""), ",");
        List<ColumnDataType> columnDataTypes = new ArrayList<ColumnDataType>();
        List<ColumnMeta> columns = new ArrayList<ColumnMeta>();
        for (int i = 0; i < q3.size(); i++) {
            List<String> q4 = StringUtil.splitString(q3.get(i), " ");
            ColumnMeta columnMeta = new ColumnMeta();
            columnMeta.setName(q4.get(0));
            columnMeta.setType(q4.get(1));
            columns.add(columnMeta);
        }
        tableMeta.setColumns(columns);

        System.out.println("Table Created Successfully");
        MetaCacheService.createTable(tableMeta);
        return tableMeta;
    }
}
