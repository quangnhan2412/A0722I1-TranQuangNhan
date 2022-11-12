package ss12_java_collection_framework_map_tree._hashmap_hashset_distinguish;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student("Nam",20,"HN");
        Student student2 = new Student("Hung",21,"HN");
        Student student3 = new Student("Ha",22,"HN");

        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(1,student);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student);

            for (Map.Entry<Integer,Student> studentEntry : studentMap.entrySet()){
                System.out.println(studentEntry.toString());
            }

        System.out.println("...............SET");
        Set<Student>studentSet= new HashSet<Student>();
        studentSet.add(student);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student);

        for (Student student1: studentSet
             ) {
            System.out.println(student1.toString());
        }
    }
}

