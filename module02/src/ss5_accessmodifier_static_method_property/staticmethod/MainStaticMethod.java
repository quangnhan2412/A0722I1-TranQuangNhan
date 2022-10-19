package ss5_accessmodifier_static_method_property.staticmethod;

public class MainStaticMethod {
    public static void main(String[] args) {
      Student.change(); //Calling change method
        //creating object
        Student s1 = new Student(1 , "Nhan");
        Student s2 = new Student(2 , "Nhan2");
        Student s3 = new Student(3 , "Nhan3");

        //Calling display method
        s1.display();
        s2.display();
        s3.display();
    }
}
