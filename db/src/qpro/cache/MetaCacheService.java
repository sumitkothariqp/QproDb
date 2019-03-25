package qpro.cache;

import qpro.meta.TableMeta;

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
}
