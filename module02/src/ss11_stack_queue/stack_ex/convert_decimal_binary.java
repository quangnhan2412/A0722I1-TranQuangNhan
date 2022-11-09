package ss11_stack_queue.stack_ex;

import java.util.Scanner;
import java.util.Stack;

public class convert_decimal_binary {
    public static void main(String[] args) {
        Stack<Integer> stack =new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Decimal :" );
        int inputDecimal = scanner.nextInt();
        while (inputDecimal>0){
            stack.push(inputDecimal %2);
            inputDecimal/=2;
        }
        System.out.println("Hệ thập phân ra nhị phân : ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
