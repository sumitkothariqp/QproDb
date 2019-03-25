package file.util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileObjectReader {
    public List<Object> readObjectsFromFile(String filename) {
        List<Object> objectsReadFromFile = new ArrayList<Object>();
        try {
            ObjectInputStream objectInput
                    = new ObjectInputStream(new FileInputStream(FileObjectUtil.getFile(filename)));

            while (true) {
                Object object = objectInput.readObject();
                objectsReadFromFile.add(object);
            }
        } catch (EOFException eof) {

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objectsReadFromFile;
    }
}
