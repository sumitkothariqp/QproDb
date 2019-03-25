package qpro.cache;

import qpro.meta.TableMeta;

import java.util.List;
import java.util.Map;

public class MetaCacheService {


    private Map<String, TableMeta> metaCache = Cache.getINSTANCE().getMetaCache();

    public boolean isTableExits(String name) {
        if (metaCache.get(name) == null) {
            return false;
        }
        return true;
    }

    public void createTable(TableMeta tableMeta) {
        metaCache.put(tableMeta.getName(), tableMeta);
    }

    public void initializeCache(List<TableMeta> tableMetaList) {
        tableMetaList.stream().forEach(tableMeta -> metaCache.put(tableMeta.getName(), tableMeta));
    }
}
