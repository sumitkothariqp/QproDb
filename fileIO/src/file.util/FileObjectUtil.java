package file.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileObjectUtil {
    public static File getFile(String filename) throws IOException {
        File file = new File("~/QProDBData/" + filename);
        file.getParentFile().mkdirs(); // Will create parent directories if not exists
        file.createNewFile();
        return file;
    }
}
