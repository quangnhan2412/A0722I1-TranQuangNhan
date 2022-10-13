package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class A2_Add_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {10, 4, 6, 7, 8, 6, 0, 0, 0};
        // 10 4 6 7 8 6
        // 2 => 100
        //10 4 100 6 7 8
        // Hiển thị mảng
        System.out.println("Property list : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        //Số muốn thêm
        System.out.println("Enter the location you want to add ");
        int input = scanner.nextInt();
        //tại vị trí
        System.out.println("IN INDEX");
        int index = scanner.nextInt();
        //
        if (index <= 1 && index >= array.length - 1) {
            System.out.println("Unable to insert element into array.");
        } else {
            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = input;
        }
        System.out.println("New array : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
