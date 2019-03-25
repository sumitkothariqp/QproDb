package qpro.cache;

import file.util.FileObjectReader;
import qpro.meta.TableMeta;

import java.util.List;
import java.util.Map;

public class MetaCacheService {


    private static Map<String, TableMeta> metaCache = Cache.getINSTANCE().getMetaCache();

    public boolean isTableExits(String name) {
        if (metaCache.containsKey(name)) {
            return false;
        }
        return true;
    }

    public TableMeta getTableMeta(String name) {
        return metaCache.get(name);
    }

    public void createTable(TableMeta tableMeta) {
        metaCache.put(tableMeta.getName(), tableMeta);
    }

    public static void initializeCache() {
        FileObjectReader fileObjectReader = new FileObjectReader();
        List<Object> fileObject = fileObjectReader.readObjectsFromFile("metadata.dat");
        List<TableMeta> tableMetaList = (List<TableMeta>) fileObject.get(0);
        if (tableMetaList != null) {
            tableMetaList.stream().forEach(tableMeta -> metaCache.put(tableMeta.getName(), tableMeta));
        }
    }
}
