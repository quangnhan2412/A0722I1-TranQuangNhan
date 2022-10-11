package ss3_Arrays_and_methods_Java;

import java.util.Scanner;

public class find_element_in_array {
    public static void main(String[] args) {
        String[] student = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        String input_name = scanner.nextLine();
        boolean isExits = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(input_name)) {
                System.out.println("Position of the students in the list " + input_name + "is : " + (i + 1));
                isExits = true;
                break;
            }
        }
        if (!isExits) {
            System.out.println("Not found " + input_name + " in the list.");
        }
    }
}
