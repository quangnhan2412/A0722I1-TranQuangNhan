package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class reverseArray {
    public static void main(String[] args) {
//        Khai báo các biến, nhập và kiểm tra kích thước mảng
        int[] array;
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Size does not exceed 20 ");
            }
        } while (size > 20);
//        Nhập giá trị cho các phần tử của mảng
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
//        In ra mảng đã nhập
        System.out.printf("\n%-20s%s", "Elements in: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        //Reverse
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("\n%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
