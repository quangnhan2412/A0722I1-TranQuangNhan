package ss5_accessmodifier_static_method_property.staticmethod;

public class Student {
    private int  rollno;
    private String name;
    private static String college = "BBDIT";
    //constructor to initialize the variable
    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODEGYM";
    }

    //method to display values
    void display() {
        System.out.println(rollno + "" + name + "" + college);
    }
}
