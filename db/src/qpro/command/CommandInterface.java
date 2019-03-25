package qpro.command;

import qpro.pojo.QueryStats;
import qpro.pojo.QueryStatus;

public interface CommandInterface {

    public boolean validate(String query);

    public Object process(String query);

    default QueryStats executeQuery(String query) {
        QueryStats stats = new QueryStats();
        if (!validate(query)) {
            stats.setQueryStatus(QueryStatus.VALIDATION_FAIL);
            return stats;
        }
        Object data = process(query);
        stats.setQueryStatus(QueryStatus.PASS);
        stats.setData(data);
        return stats;
    }

}
