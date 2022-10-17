package ss4_Classes_and_Objects_Java;

public class Rectangle01 {
    double width, height;

    public Rectangle01() {

    }

    public Rectangle01(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width * this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "Width=" + width + ",height=" + height + "}";
    }
}


