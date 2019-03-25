package qpro.meta;

import qpro.util.StringUtil;

import java.util.Arrays;

public enum ColumnDataType {


    INT("int") {
        public boolean validateData(String data) {
            return StringUtil.isNumeric(data);

        }
    },
    TEXT("text") {
        public boolean validateData(String data) {
            return StringUtil.isNotEmpty(data);

        }
    };

    private String type;

    ColumnDataType(String type) {
        this.type = type;
    }

    public static ColumnDataType getByType(String type) {
        return Arrays.stream(ColumnDataType.values()).filter(e -> e.type.equals(type)).findFirst().orElse(null);
    }

    abstract boolean validateData(String data);

}
