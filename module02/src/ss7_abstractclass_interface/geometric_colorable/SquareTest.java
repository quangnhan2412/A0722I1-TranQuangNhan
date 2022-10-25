package ss7_abstractclass_interface.geometric_colorable;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        square.howToColor();
        System.out.println(square);
        System.out.println("=================");

        Square[] squaresTwo = new Square[3];
        squaresTwo[0] = new Square();
        squaresTwo[1] = new Square("Red", true, 10);
        squaresTwo[2] = new Square();

        for (int i = 0; i < squaresTwo.length; i++) {
            System.out.println("Square " + i + ": " + squaresTwo[i]);
            if (squaresTwo[i] instanceof Square)
                squaresTwo[i].howToColor();
        }
    }
}
