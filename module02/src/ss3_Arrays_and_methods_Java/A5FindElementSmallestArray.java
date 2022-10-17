package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class A5FindElementSmallestArray {
    public static void main(String[] args) {
        int[] arr;
        Scanner scanner = new Scanner(System.in);
        int size;
        System.out.print("Enter size arr : ");
        size = scanner.nextInt();
        arr = new int[size];
        int i = 0;
        while (i < arr.length) {
            System.out.print(" Enter element " + (i + 1) + " ");
            arr[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Array is : ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        int min = arr[0] ;
        for (int j = 0; j < arr.length; j++) {
            if(min > arr[j]){
                min = arr[j];
            }
        }
        System.out.println();
        System.out.println(min + " is smallest in arr");
    }
}

