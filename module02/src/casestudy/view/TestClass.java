package casestudy.view;


import casestudy.ultils.RegexMenu;
import casestudy.ultils.RegexPerson;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static casestudy.ultils.RegexPerson.inputBirthday;

public class TestClass {
    Scanner scanner = new Scanner(System.in);

    public static void update() {

    }

    public static void main(String[] args) {
        int check = RegexMenu.inputChoiceMenu();
        switch (check){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("No choice!");
        }

}
}

