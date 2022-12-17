package module2.ultils;

import casestudy.models.person.Employee;
import module2.model.TaiKhoanNganHang;
import module2.model.TaiKhoanThanhToan;
import module2.model.TaiKhoanTietKiem;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static module2.ultils.RegexDay.dateInputDOB;

public class ReadAndWriteFileCSV {
    //*Read
    public static ArrayList<TaiKhoanNganHang> readFromFile(String pathFile) {
        ArrayList<TaiKhoanNganHang> accounts = new ArrayList<>();
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] props = line.split(",");
                if (props.length == 6) {
                    accounts.add(new TaiKhoanThanhToan(props[0],props[1],props[2],
                            dateInputDOB( props[3]) ,(props[4]),props[5]));
                } else {
                    accounts.add(new TaiKhoanTietKiem(props[0],props[1],props[2],dateInputDOB(props[3]),props[4],dateInputDOB(props[5]),
                          props[6],  Integer.parseInt(props[7])));
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    //Write
    private static void writeListStringTOCSV(ArrayList<String> stringList, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Err File!!!");
        }
    }

    //Tai khoan thanh toan
    public static void writeListTaiKhoanThanhToanTOCSV(ArrayList<TaiKhoanNganHang> thanhToans, String pathFile, boolean append) {
        ArrayList<String> stringList = new ArrayList<>();
        for (TaiKhoanNganHang taiKhoanNganHang : thanhToans) {
            stringList.add(taiKhoanNganHang.getInfo());
        }
        writeListStringTOCSV(stringList, pathFile, append);
    }
}
