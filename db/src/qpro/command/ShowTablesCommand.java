package qpro.command;

import qpro.cache.MetaCacheService;
import qpro.meta.TableMeta;

import java.util.Collection;

public class ShowTablesCommand implements CommandInterface {

    public boolean isValidate(String query) {

        return true;
    }

    public Object process(String query) {
        Collection<TableMeta> tableMetas = MetaCacheService.getAllTables();
        tableMetas.stream().forEach(n-> System.out.println(n.getName()));
        return null;
    }
}