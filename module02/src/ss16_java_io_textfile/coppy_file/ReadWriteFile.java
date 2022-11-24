package ss16_java_io_textfile.coppy_file;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    //Read File
    public static ArrayList<String> readFile(String pathFile) {
        ArrayList<String> listLine = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listLine;
    }

    //Write File
    public static void writeFile(String pathFile, ArrayList<String> lines) {
        int count = 0;
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

//            for (String item : lines) {
//                bufferedWriter.write(item);
//                bufferedWriter.newLine();
//                count += item.length();
//            }
//
            for (int i = 0; i < lines.size(); i++) {
                bufferedWriter.write(lines.get(i)+"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final String COPY = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\ss16_java_io_textfile\\coppy_file\\fileCopy.txt";
        final String PASTE = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\ss16_java_io_textfile\\coppy_file\\filePaste.txt";
        ArrayList<String> lines = readFile(COPY);
        System.out.println("File copied to" );
        writeFile(PASTE,lines);
    }
}
