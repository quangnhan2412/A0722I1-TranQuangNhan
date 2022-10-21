package ss6_inheritance.point_moveablepoint;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
         point = new Point(1.5f,2.5f);
        System.out.println(point);

        System.out.println();

        MovablePoint movablePoint=new MovablePoint();
        System.out.println(movablePoint);
        movablePoint = new MovablePoint(10.5f,9.5f,5.2f,6.2f);
        System.out.println(movablePoint);
    }
}
