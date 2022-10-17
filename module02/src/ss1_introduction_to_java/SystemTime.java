package ss1_introduction_to_java;

import java.util.Date;

//Hiển thị giờ hệ thống
public class SystemTime {
    public static void main(String[] args) {
        Date now = new Date();//Lấy ra thời gian hiện tại

        System.out.println("Now is:  " + now);
    }
}
