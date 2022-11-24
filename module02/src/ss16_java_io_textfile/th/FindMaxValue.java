package ss16_java_io_textfile.th;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\ss16_java_io_textfile\\th\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\ss16_java_io_textfile\\th\\result.txt", maxValue);
    }
}
