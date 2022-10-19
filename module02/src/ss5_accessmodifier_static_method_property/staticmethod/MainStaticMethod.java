package ss5_accessmodifier_static_method_property.staticmethod;

public class MainStaticMethod {
    public static void main(String[] args) {
        StaticMethod.Student.change();
        //Calling change method
        //creating object
        StaticMethod.Student s1 = new StaticMethod.Student(11,"Hoang");
    }
}
