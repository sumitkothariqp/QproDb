package qpro.cache;

import file.util.FileObjectReader;
import file.util.FileObjectWriter;
import qpro.meta.TableMeta;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MetaCacheService {


    public static final String METADATA_DAT = "metadata.dat";
    private static Map<String, TableMeta> metaCache = Cache.getINSTANCE().getMetaCache();

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

    public static void dropTable(String name) {
        metaCache.remove(name);
    }

    public static void initializeCache() {
        FileObjectReader fileObjectReader = new FileObjectReader();
        List<Object> fileObject = fileObjectReader.readObjectsFromFile(METADATA_DAT);
        if (fileObject != null && fileObject.size() > 0) {
            Collection<TableMeta> tableMetaList = (Collection<TableMeta>) fileObject.get(0);
            tableMetaList.stream().forEach(tableMeta -> metaCache.put(tableMeta.getName(), tableMeta));
        }
    }

    public static void dumpToFile() {
        String filename = METADATA_DAT;
        FileObjectWriter fileObjectWriter = new FileObjectWriter();

        fileObjectWriter.writeObjectToFile(metaCache.values().stream().collect(Collectors.toList()), filename);
    }
}
