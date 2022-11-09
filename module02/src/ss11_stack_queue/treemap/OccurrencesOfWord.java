package ss11_stack_queue.treemap;

import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

public class OccurrencesOfWord {
    public static void main(String[] args) {
        //Chương trình sử dụng một TreeMap để lưu trữ một mục bao gồm một từ và số lượng của nó.
        //
        //Duyệt toàn bộ từ trong chuỗi.
        //Mỗi từ lấy ra từ chuỗi, chuyển toàn bộ thành chữ hoa hoặc chữ thường. Coi mỗi từ được lấy ra từ chuỗi là 1 key.
        //Kết thúc duyệt chuỗi. Hiển thị map gồm key (từ) và value (số lượng mỗi từ).
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String : ");
        String inputStr = scanner.nextLine();
        inputStr = inputStr.toLowerCase(Locale.ROOT);
        String[] arrayStr = inputStr.split(" ");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < arrayStr.length; i++) {
            //Kiểm tra trong map có key hay chưa ,Nếu có đẩy key này vào map và tăng value (số lượng từ) lên 1 Nếu key
            //        // này chưa có trong map thì đẩy key vào map mặc định gán value là 1.
            if (!treeMap.containsKey(arrayStr[i])) {
                treeMap.put(arrayStr[i], 1);
            } else {
                treeMap.put(arrayStr[i], treeMap.get(arrayStr[i]) + 1);
            }
        }
        System.out.println(treeMap);
    }
}
