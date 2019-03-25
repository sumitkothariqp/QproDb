package qpro.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {

    private Map<String, List<Object>> cache = new HashMap<>();

    private static Cache INSTANCE = new Cache();

    public static Cache getINSTANCE() {
        return INSTANCE;
    }

    public List<Object> getCache(String cacheId) {
        return cache.get(cacheId);
    }

    public void addCache(String cacheId, List<Object> values) {
        cache.put(cacheId, values);
    }
}
