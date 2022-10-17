package ss2_Loop_Java;

public class A3DisplayPrimeLessthan100 {

    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i + " is Prime");
            }
        }
    }
    //Check PRIME
    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        //Check isPrime khi n>=2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
