package ss11_stack_queue.stack;

public class
MyGenericStackClient {
    public static void stackOfString() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("three");
        stack.push("Two");
        stack.push("Two");
        stack.push("One");
        System.out.println("1.1 Size of stack after push operations: " + stack.size());
        System.out.printf("1.2. Pop elements from stack : ");
//        String topElement = stack.stack.peek();
//        System.out.println(topElement);
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
//        stack.push("Five");
//        stack.push("Four");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println();
        }
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n1.3. Size of stack after pop operations : " + stack.size());
    }

    public static void stackOfInteger() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("1.1 Size of stack after push operations: " + stack.size());
        System.out.printf("1.2. Pop elements from stack : ");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\n1.3. Size of stack after pop operations : " + stack.size());

    }

    public static void main(String[] args) {
        System.out.println("\n1. Stack of Strings");
        stackOfString();
        System.out.println("\n2. Stack of Integer");
        stackOfInteger();

    }

}
