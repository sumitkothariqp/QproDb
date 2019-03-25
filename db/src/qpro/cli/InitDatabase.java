package qpro.cli;

import qpro.cache.DataCacheService;
import qpro.cache.MetaCacheService;

public class InitDatabase {


    public static void init() {
        System.out.println("Initializing database...");
        MetaCacheService.initializeCache();
        DataCacheService.initializeCache();

    }

    public static void dumpInFile() {
        System.out.println("Gracefully shutting down...");
        MetaCacheService.dumpToFile();
        DataCacheService.dumpToFile();
    }

}
