package qpro.cache;

import qpro.meta.TableMeta;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MetaCacheService {


    private static  Map<String, TableMeta> metaCache = Cache.getINSTANCE().getMetaCache();

    public static boolean isTableExits(String name) {
        if (metaCache.containsKey(name)) {
            return true;
        }
        return false;
    }

    public static TableMeta getTableMeta(String name) {
        return metaCache.get(name);
    }

    public static Collection<TableMeta> getAllTables() {
        return metaCache.values();
    }

    public static void createTable(TableMeta tableMeta) {
        metaCache.put(tableMeta.getName(), tableMeta);
    }

    public static void initializeCache(List<TableMeta> tableMetaList) {
        tableMetaList.stream().forEach(tableMeta -> metaCache.put(tableMeta.getName(), tableMeta));
    }
}
