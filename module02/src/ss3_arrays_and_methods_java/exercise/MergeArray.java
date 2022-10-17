package ss3_arrays_and_methods_java.exercise;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] array1;
        int[] array2;
        int size1, size2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size array one: ");
        size1 = scanner.nextInt();
        array1 = new int[size1];
        int i = 0;

        while (i < array1.length) {
            System.out.print("Enter element " + (i + 1) + " of array 1 ");
            array1[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Enter size array two: ");
        size2 = scanner.nextInt();
        array2 = new int[size2];
        int j = 0;
        while (j < array2.length) {
            System.out.print("Enter element " + (j + 1) + " of array 2 ");
            array2[j] = scanner.nextInt();
            j++;
        }
        System.out.print("Array once : ");
        for (int k : array1) {
            System.out.print(k + " \t");

        }
        System.out.print("Array Two : ");
        for (int t : array2) {
            System.out.print(t + " \t");
        }
        int[] arrayTotal = new int[array1.length + array2.length];
        for (int k = 0; k < arrayTotal.length; k++) {
            if (k < array1.length) {
                arrayTotal[k] = array1[k];
            } else {
                arrayTotal[k] = array2[k - array1.length];
            }
        }
        System.out.print("New array: ");
        for (int value : arrayTotal) {
            System.out.print(value + "\t");
        }
    }
}
