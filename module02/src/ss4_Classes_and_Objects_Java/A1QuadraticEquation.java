package ss4_Classes_and_Objects_Java;

public class A1QuadraticEquation {
    private double a, b, c;

    public A1QuadraticEquation() {

    }

    public A1QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return (Math.pow(b, 2) - 4 * this.a * this.c);
    }

    public double getRoot1() {
        if (this.getDiscriminant() >= 0) return ((-b + Math.sqrt(this.getDiscriminant())) / (2 * a));
        else return 0;
    }
    public double getRoot2() {
        if (this.getDiscriminant() >= 0) return ((-b - Math.sqrt(this.getDiscriminant())) / (2 * a));
        else return 0;
    }
}
