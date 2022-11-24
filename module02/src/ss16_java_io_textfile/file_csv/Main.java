package ss16_java_io_textfile.file_csv;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String URL = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\ss16_java_io_textfile\\file_csv\\country.csv";


    public static List<Country> readCSV(String url) {
        List<Country> listLine = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(URL);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Country country;

            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String code = temp[1];
                String name = temp[2];

                country = new Country(id, code, name);
                listLine.add(country);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }

    public static void main(String[] args) {
        List<Country> countryList = readCSV(URL);
        for (Country country : countryList) {
            System.out.println(country);
        }
    }
}


