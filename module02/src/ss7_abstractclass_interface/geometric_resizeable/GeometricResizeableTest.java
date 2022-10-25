package ss7_abstractclass_interface.geometric_resizeable;

import java.util.concurrent.ThreadLocalRandom;

public class GeometricResizeableTest {
    public static void main(String[] args) {
        Circle[] circle = new Circle[3];
        circle[0] = new Circle();
        circle[1] = new Circle();
        circle[2] = new Circle();
        for (int i = 0; i < circle.length; i++) {
            System.out.println("Circle " + i + ": " + circle[i]);
            int ranNum = ThreadLocalRandom.current().nextInt(1,101);
            System.out.println(ranNum + " " + circle[i].resize(ranNum));
        }

        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0]=new Rectangle();
        rectangles[1]=new Rectangle();
        rectangles[2]=new Rectangle();
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Rectangle " + i + " : " + rectangles[i]);
            int ranNum = ThreadLocalRandom.current().nextInt(1,101);
            System.out.println(ranNum + " " + rectangles[i].resize(ranNum));
        }
    }
}
