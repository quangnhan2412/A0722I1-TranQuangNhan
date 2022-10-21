package ss6_inheritance.triangle;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("Blue",false);
        System.out.println(shape);

        System.out.println();

        Triangle triangle = new Triangle();
        System.out.println(triangle);

        triangle = new Triangle("Blue",true,2.3,2.3,2.4);
        System.out.println(triangle);
    }
}
