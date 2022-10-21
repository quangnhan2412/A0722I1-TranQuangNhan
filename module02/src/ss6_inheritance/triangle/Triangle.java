package ss6_inheritance.triangle;

public class Triangle extends Shape {
    double sideOne = 1.0;
    double sideTwo = 1.0;
    double sideThree = 1.0;

    public Triangle() {

    }

    public Triangle(double sideOne, double sideTwo, double sideThree) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    public Triangle(String color, boolean filled, double sideOne, double sideTwo, double sideThree) {
        super(color, filled);
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    public double getSideOne() {
        return sideOne;
    }

    public void setSideOne(double sideOne) {
        this.sideOne = sideOne;
    }

    public double getSideTwo() {
        return sideTwo;
    }

    public void setSideTwo(double sideTwo) {
        this.sideTwo = sideTwo;
    }

    public double getSideThree() {
        return sideThree;
    }

    public void setSideThree(double sideThree) {
        this.sideThree = sideThree;
    }

    public double getArea() {
        double halfPerimeterTriangle = (sideOne + sideTwo + sideThree) / 2;
        double area = Math.sqrt(halfPerimeterTriangle * (halfPerimeterTriangle - sideOne )* (halfPerimeterTriangle - sideTwo) * (halfPerimeterTriangle - sideThree));
        return area;
    }

    public double getPerimeter() {
        return (sideOne + sideTwo + sideThree);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                ", sideOne=" + sideOne +
                ", sideTwo=" + sideTwo +
                ", sideThree=" + sideThree +
                ", Area=" + getArea() +
                ", Perimeter" + getPerimeter() +
                '}';
    }
}
