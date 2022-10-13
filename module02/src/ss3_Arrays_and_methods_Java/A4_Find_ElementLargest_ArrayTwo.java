package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class A4_Find_ElementLargest_ArrayTwo {
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
        double largest = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= array.length; j++) {
                if (largest < array[i][j]) {
                    largest = array[i][j];
                }
            }
        }
        System.out.println();
        System.out.println(largest + " Largest");
    }
}
