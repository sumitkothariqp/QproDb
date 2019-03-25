package qpro.command;

import qpro.cache.MetaCacheService;
import qpro.meta.ColumnMeta;
import qpro.meta.TableMeta;
import qpro.util.StringUtil;

import java.util.Collection;
import java.util.List;

public class ShowTablesCommand implements CommandInterface {

    public boolean validate(String query) {

        return true;
    }

    public Object process(String query) {
        List<String> strings = StringUtil.splitString(query," ");
        if (strings.size() > 2) {
            TableMeta tableMeta = MetaCacheService.getTableMeta(strings.get(2));
            if (tableMeta == null) {
                System.out.println("Table not found");
                return null;
            }
            System.out.println("Table : " + tableMeta.getName());
            System.out.println("Columns : ");
            for(ColumnMeta columnMeta : tableMeta.getColumns()) {
                System.out.println(columnMeta.getName() + "   " + columnMeta.getType());
            }
        } else {
            Collection<TableMeta> tableMetas = MetaCacheService.getAllTables();
            tableMetas.stream().forEach(n -> System.out.println(n.getName()));
        }
        return null;
    }
}