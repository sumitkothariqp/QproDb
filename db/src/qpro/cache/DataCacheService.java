package qpro.cache;

import file.util.FileObjectReader;
import qpro.meta.TableMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCacheService {

    private static Map<String, List<Map<String, Object>>> tableCache = Cache.getINSTANCE().getTableCache();

    public static void initializeCache() {
        Map<String, TableMeta> metaCache = Cache.getINSTANCE().getMetaCache();
        metaCache.forEach((tableName,tableMeta)->{
            populateTableCache(tableName);
        });
    }

    private static void populateTableCache(String tableName) {
        FileObjectReader fileObjectReader = new FileObjectReader();
        List<Object> fileObject = fileObjectReader.readObjectsFromFile(tableName);
        List tableRows = (List) fileObject.get(0);
        if (tableRows != null) {
            tableCache.put(tableName, tableRows);
        }
    }

    public static void insertRow(String tableName, Map<String, Object> tableRow) {
        if (MetaCacheService.isTableExist(tableName)){
            addTableRowInTableCache(tableName, tableRow);
        }
    }

    private static void addTableRowInTableCache(String tableName, Map<String, Object> tableRow) {
        if (tableCache.containsKey(tableName)) {
            tableCache.get(tableName).add(tableRow);
        } else {
            List<Map<String, Object>> table = new ArrayList<>();
            table.add(tableRow);
            tableCache.put(tableName, table);
        }
    }

    public static void deleteRow(String tableName, int id) {
        if (MetaCacheService.isTableExist(tableName)){
            removeRowFromTableCache(tableName, id);
        }
    }

    private static void removeRowFromTableCache(String tableName, int id) {
        if (tableCache.containsKey(tableName)) {
            if(id == 0) {
                tableCache.put(tableName, new ArrayList<>());
            }
            List<Map<String, Object>> table = tableCache.get(tableName);
            table.forEach(row -> {
                if(row.containsKey(Integer.toString(id))) {
                    table.remove(row);
                }
            });
        }
    }
}
