package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class A7_Sum_Diagonal_OfA_SquareMatrix {
    public static void main(String[] args) {
        int column, row;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter column : ");
        column = scanner.nextInt();
        System.out.print("Enter row : ");
        row = scanner.nextInt();
        double[][] array = new double[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print("Enter the element" + "[" + i + "]" + "[" + j + "] : ");
                array[i][j] = scanner.nextDouble();
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
        }
        System.out.println("Total Matrix");
        int Total = 0;
        for (int i = 0; i < array.length; i++) {
            Total += array[i][i];
        }
        System.out.println();
        System.out.println("Total Matrix: " + Total );
    }
}
