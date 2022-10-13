package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class A6_Total_ASpecifiedColumn_ArrayTwo {
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
        System.out.println("How many columns do you want to sum starting from 0 ?  ");
        int input = scanner.nextInt();
        float sum = 0;
        for (double[] doubles : array) {
            sum += doubles[input];
        }
        System.out.println("The sum of column " + input + " = " + sum);
    }
}
