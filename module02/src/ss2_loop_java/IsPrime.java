package ss2_loop_java;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner prime = new Scanner(System.in);
        System.out.println("Enter a Number");
        int Number = prime.nextInt();
        if(Number <2 ){
            System.out.println(Number + " is not Prime");
        }else{
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(Number)){
                if (Number % i == 0){
                    check = false;
                    break;
                }
                i++;
            }
            if(check)
                System.out.println(Number + " is the Prime");
            else
                System.out.println(Number + " is not Prime");
        }
    }
}
