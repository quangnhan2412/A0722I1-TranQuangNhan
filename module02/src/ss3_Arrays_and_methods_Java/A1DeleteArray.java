package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class A1DeleteArray {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 7, 8, 6};
        // Hiển thị mảng
            System.out.println("Property list : ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Enter the location you want to delete ");
        //nhập vị trí muốn xoá
        int input = scanner.nextInt();
        int index = -1;
        for (int j = 0; j < array.length; j++) {
            if (input == array[j]) index = j;
        }
        if (index == -1) {
            System.out.print("Please re-enter the keyword in the array :");
        } else {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        System.out.println("New Array : ");
        for (int j = 0; j < array.length-1; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}