package qpro.cache;

import file.util.FileObjectReader;
import file.util.FileObjectWriter;
import qpro.meta.ColumnMeta;
import qpro.meta.TableMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataCacheService {

    private static Map<String, List<Map<String, Object>>> tableCache = Cache.getINSTANCE().getTableCache();

    public static void initializeCache() {
        Map<String, TableMeta> metaCache = Cache.getINSTANCE().getMetaCache();
        metaCache.forEach((tableName, tableMeta) -> {
            populateTableCache(tableName);
        });
    }

    private static void populateTableCache(String tableName) {
        FileObjectReader fileObjectReader = new FileObjectReader();
        List<Object> fileObject = fileObjectReader.readObjectsFromFile(tableName);
        if (fileObject != null && fileObject.size() > 0) {
            List tableRows = (List) fileObject.get(0);
            if (tableRows != null) {
                tableCache.put(tableName, tableRows);
            }
        }
    }

    public static List<Map<String, Object>> getAllRows(String table) {
        return getRowData(table, 0);
    }

    public static List<Map<String, Object>> getRowData(String table, Integer id) {
        if (tableCache.get(table) == null || tableCache.get(table).size() == 0) {
            return null;
        }
        if (id == 0) {
            return tableCache.get(table);
        }
        return tableCache.get(table).stream().filter(e -> id.equals(e.get("id"))).collect(Collectors.toList());
    }

    public static void insertRow(String tableName, Map<String, Object> tableRow) {
        if (MetaCacheService.isTableExist(tableName)) {
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
        if (MetaCacheService.isTableExist(tableName)) {
            removeRowFromTableCache(tableName, id);
        }
    }

    private static void removeRowFromTableCache(String tableName, int id) {
        if (tableCache.containsKey(tableName)) {
            if (id == 0) {
                tableCache.put(tableName, new ArrayList<>());
            }
            List<Map<String, Object>> table = tableCache.get(tableName);
            TableMeta tableMeta = MetaCacheService.getTableMeta(tableName);
            ColumnMeta columnMeta = tableMeta.getColumns().get(0);
            List<Map<String, Object>> filteredList = table.stream().filter(row -> !(String.valueOf(id).equals( row.get(columnMeta.getName())))
            ).collect(Collectors.toList());
            tableCache.put(tableName, filteredList);
        }
    }

    public static void dumpToFile() {

        for (String key : Cache.getINSTANCE().getMetaCache().keySet()) {
            FileObjectWriter fileObjectWriter = new FileObjectWriter();
            fileObjectWriter.writeObjectToFile(tableCache.get(key), key);
        }


    }
}
