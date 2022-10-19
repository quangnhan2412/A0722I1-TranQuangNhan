package ss5_accessmodifier_static_method_property.exercise.accessmodifier.one.two;

public class Student {
    private String name = "John";
    private String classA ="C02";

    Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getClassA() {
        return classA;
    }

    public void setClassA(String classA) {
        this.classA = classA;
    }
}
