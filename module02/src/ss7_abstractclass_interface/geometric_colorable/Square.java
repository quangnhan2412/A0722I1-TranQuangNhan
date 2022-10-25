package ss7_abstractclass_interface.geometric_colorable;

public class Square extends Shape implements Colorable {
    private double side = 1.0;


    public Square() {

    }

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getPerimeter() {
        return 4 * side;
    }

    public double getArea() {
        return Math.pow(side, 2);

    }


    @Override
    public String toString() {
        return super.toString() + " and perimeter is: " + getPerimeter() + ", area is: " + getArea();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
