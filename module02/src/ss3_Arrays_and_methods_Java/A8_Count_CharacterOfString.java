package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class A8_Count_CharacterOfString {
    public static void main(String[] args) {
        //Hàm str.length() trả về tổng số ký tự trong một chuỗi str
        //
        //Hàm str.charAt(i) trả về ký tự ở vị trí thứ i trong chuỗi str
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter to Str : ");
        String str = scanner.nextLine();

        System.out.print("Enter character find : ");
        char inputStr = scanner.next().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (inputStr == (str.charAt(i))) count++;
        }
        if (count != 0) {
            System.out.println("number of occurrences in String is : " + count + " Character : " + inputStr);
        } else {
            System.out.println("Không có ký tự trong String : ");
        }
    }
}
