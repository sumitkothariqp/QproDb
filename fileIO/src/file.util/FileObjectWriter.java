package file.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileObjectWriter {

    public void writeObjectToFile(Object object, String filename) {
        try {
            ObjectOutputStream objectOutput
                    = new ObjectOutputStream(new FileOutputStream(FileObjectUtil.getFile(filename)));
            objectOutput.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
