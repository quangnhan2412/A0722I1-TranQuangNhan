package ss5_accessmodifier_static_method_property.exercise.accessmodifier.one.two;

public class MainStudent {
    public static void main(String[] args) {
        Student studentOne = new Student();

        studentOne.setName("Nhan");
        studentOne.setClassA("A07");

        System.out.println(studentOne.getName());
        System.out.println(studentOne.getClassA());
    }
}
