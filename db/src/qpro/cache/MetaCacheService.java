package qpro.cache;

import file.util.FileObjectReader;
import qpro.meta.TableMeta;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MetaCacheService {


    private static  Map<String, TableMeta> metaCache = Cache.getINSTANCE().getMetaCache();

    public static boolean isTableExist(String name) {
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

    public static void dropTable(String name){metaCache.remove(name);
    }

    public static void initializeCache() {
        FileObjectReader fileObjectReader = new FileObjectReader();
        List<Object> fileObject = fileObjectReader.readObjectsFromFile("metadata.dat");
        List<TableMeta> tableMetaList = (List<TableMeta>) fileObject.get(0);
        tableMetaList.stream().forEach(tableMeta -> metaCache.put(tableMeta.getName(), tableMeta));
    }
}
