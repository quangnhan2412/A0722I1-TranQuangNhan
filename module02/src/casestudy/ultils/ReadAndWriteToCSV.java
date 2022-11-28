package casestudy.ultils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class ReadAndWrite {

    //Write
    public static void write(Collection collection, String pathFile) {
        File file = new File(pathFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
File

        }
    }
    //Read
    public void readFileText(String filePath){
        File file = new File(filePath);

        if(!file.exists())
            
    }
}