package com.qpro.pojo;

public class QueryStats {

    private QueryStatus queryStatus;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public QueryStatus getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(QueryStatus queryStatus) {
        this.queryStatus = queryStatus;
    }
}
