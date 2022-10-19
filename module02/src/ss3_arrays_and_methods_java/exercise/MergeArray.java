package ss3_arrays_and_methods_java.exercise;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] arrayA;
        int[] arrayB;
        int sizeOne, sizeTwo;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size array one: ");
        sizeOne = scanner.nextInt();
        arrayA = new int[sizeOne];
        int i = 0;

        while (i < arrayA.length) {
            System.out.print("Enter element " + (i + 1) + " of array 1 ");
            arrayA[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Enter size array two: ");
        sizeTwo = scanner.nextInt();
        arrayB = new int[sizeTwo];
        int j = 0;
        while (j < arrayB.length) {
            System.out.print("Enter element " + (j + 1) + " of array 2 ");
            arrayB[j] = scanner.nextInt();
            j++;
        }
        System.out.print("Array once : ");
        for (int k : arrayA) {
            System.out.print(k + " \t");

        }
        System.out.print("Array Two : ");
        for (int t : arrayB) {
            System.out.print(t + " \t");
        }
        int[] arrayTotal = new int[arrayA.length + arrayB.length];
        for (int k = 0; k < arrayTotal.length; k++) {
            if (k < arrayA.length) {
                arrayTotal[k] = arrayA[k];
            } else {
                arrayTotal[k] = arrayB[k - arrayA.length];
            }
        }
        System.out.print("New array: ");
        for (int value : arrayTotal) {
            System.out.print(value + "\t");
        }
    }
}
