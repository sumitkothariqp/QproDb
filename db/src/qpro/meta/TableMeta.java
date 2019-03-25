package qpro.meta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableMeta implements Serializable {

    private String name;
    private List<ColumnMeta> columns = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ColumnMeta> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnMeta> columns) {
        this.columns = columns;
    }
}
