package com.qpro.command;

import com.qpro.pojo.QueryStats;
import com.qpro.pojo.QueryStatus;

public interface CommandInterface {
    public boolean isValidate(String query);

    public Object process(String query);


    default QueryStats executeQuery(String query) {
        QueryStats stats = new QueryStats();
        if(!isValidate(query)) {
            stats.setQueryStatus(QueryStatus.VALIDATION_FAIL);
            return stats;
        }
        Object data = process(query);
        stats.setQueryStatus(QueryStatus.PASS);
        stats.setData(data);
        return stats;
    }
}
