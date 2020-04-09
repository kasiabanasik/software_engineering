package importfromfiles.utils;

import java.io.File;

public class FileReader {

    public static File readFile(String filePath) {
        return new File(filePath);
    }
}
