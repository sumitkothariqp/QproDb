package qpro.cache;

import qpro.meta.TableMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {

    private Map<String, TableMeta> metaCache = new HashMap<>();

    private Map<String, List<Map<String, Object>>> tableCache = new HashMap<>();

    private static Cache INSTANCE = new Cache();

    public static Cache getINSTANCE() {
        return INSTANCE;
    }

    public Map<String, TableMeta> getMetaCache() {
        return metaCache;
    }

    public void setMetaCache(Map<String, TableMeta> metaCache) {
        this.metaCache = metaCache;
    }

    public Map<String, List<Map<String, Object>>> getTableCache() {
        return tableCache;
    }

    public void setTableCache(Map<String, List<Map<String, Object>>> tableCache) {
        this.tableCache = tableCache;
    }
}
