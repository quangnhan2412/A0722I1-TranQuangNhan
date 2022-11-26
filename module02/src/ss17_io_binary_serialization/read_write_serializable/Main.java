package ss17_io_binary_serialization.read_write_serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String students = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\ss17_io_binary_serialization\\read_write_serializable\\student.txt";

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFormFile(String path) throws IOException {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //Ep Kieu
            students = (List<Student>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nhan", "Da Nang"));
        students.add(new Student(2, "AAA", "Ha Noi"));
        students.add(new Student(3, "BBB", "Sing"));
        students.add(new Student(4, "CCC", "Hue"));
        students.add(new Student(5, "DDD", "Lao"));
        writeToFile(Main.students, students);
        List<Student> studentDataFromFile = null;
        try {
            studentDataFromFile = readDataFormFile(Main.students);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }


}
