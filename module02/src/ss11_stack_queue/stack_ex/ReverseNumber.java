package ss11_stack_queue.stack_ex;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseNumber {
    public static void main(String[] args) {
        //Reverse number
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        for (int i = 0; i < 10; i++) {
            Integer integer = scanner.nextInt();
            stack.push(integer);
        }
        System.out.println("Reverse Number ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        //Reverse String
        Stack<String> stackStr = new Stack<>();
        Scanner scStr = new Scanner(System.in);
        System.out.println("Enter String ");
        String string = scStr.nextLine();

        String[] stringArr = string.split(" ");
        for (String item : stringArr) {
            stackStr.push(item);
        }

        System.out.println("Reverse String ");
        while (!stackStr.isEmpty()) {
            System.out.print(Arrays.toString(stackStr.pop().split(" ")));
        }

    }
}


