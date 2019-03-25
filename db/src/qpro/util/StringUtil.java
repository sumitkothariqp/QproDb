package qpro.util;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class StringUtil {
    public static boolean isNumeric(String val) {
        return (val != null && !"".equals(val.trim()) && val.matches("^[-+]?[0-9]*\\.?[0-9]+$"));
    }

    public static boolean isEmpty(String val) {
        if (val == null) {
            return true;
        }
        if ("".equals(val.trim())) {
            return true;
        }

        return false;
    }

    public static boolean isNotEmpty(String val) {
        return !isEmpty(val);
    }


    public static List<String> splitString(String val, String regex) {
        String[] output=val.split(regex);
        return Arrays.stream(output).filter(e -> !e.isBlank()).map(String::strip).collect(Collectors.toList());
    }
}
