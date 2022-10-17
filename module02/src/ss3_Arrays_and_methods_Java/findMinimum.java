package ss3_Arrays_and_methods_Java;

public class findMinimum {
    public static int minValue(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] array = {4, 12, 7, 8, 1, 6, 9, 1};
        int index = minValue(array);
        System.out.println("The smallest element in the array is: " + array[index]);
    }
}
