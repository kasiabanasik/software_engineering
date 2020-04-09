package importfromfiles.service;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    public void saveToFile(String item, String pathToFile) throws IOException {
        FileWriter fileWriter = new FileWriter(pathToFile, true);
        fileWriter.append(item);
        fileWriter.append(System.lineSeparator());
        fileWriter.close();
    }
}
