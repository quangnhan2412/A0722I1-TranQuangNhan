package ss1_Introduction_to_Java;

import java.util.Scanner;

public class A2ReadANumber {
    public static void main(String[] args) {
        System.out.println("Enter a Number:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] readNumber = {"zero", "Once", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String result = "";
        if (input < 10) {
            for (int i = 0; i < 10; i++) {
                if (i == input) {
                    result = readNumber[i];
                    break;
                }
            }
            System.out.println(result);
        } else {
            if (input < 20) {
                int units = input % 10;
                switch (input) {
                    case 11:
                        result = "Eleven";
                        break;
                    case 12:
                        result = "Twelve";
                        break;
                    case 13:
                        result = "Thirteen";
                        break;
                    case 15:
                        result = "Fifteen";
                        break;
                    default:
                        result = readNumber[units] + "teen";
                        break;
                }
                if (units == 0) result = "Ten";
            } else {
                if (input < 100) {
                    int dozens = input / 10;
                    int units = input % 10;
                    switch (dozens) {
                        case 2:
                            result = "Twenty";
                            break;
                        case 3:
                            result = "Thirty";
                            break;
                        case 5:
                            result = "Fifty";
                            break;
                        default:
                            result = readNumber[dozens] + "ty-";
                    }
                    if (units != 0) {
                        result += readNumber[units];
                    }
                } else {
                    if (input < 1000) {
                        int hundreds = input / 100;
                        int tens = (input - (hundreds * 100)) / 10;
                        int units = input % 10;

                        result = readNumber[hundreds] + " hundred ";

                        if (tens == 0) {
                            if (units != 0)
                                result += readNumber[units];
                        } else {
                            if (tens == 1) {
                                switch (units) {
                                    case 1:
                                        result += "and eleven";
                                        break;
                                    case 2:
                                        result += "and twelve";
                                        break;
                                    case 3:
                                        result += "and thirteen";
                                        break;
                                    case 5:
                                        result += "and fifteen";
                                        break;
                                    case 0:
                                        result += "and ten ";
                                        break;
                                    default:
                                        result += "and " + readNumber[units] + "teen";
                                        break;
                                }
                            } else {
                                switch (tens) {
                                    case 2:
                                        result += "and twenty ";
                                        break;
                                    case 3:
                                        result += "and thirty ";
                                        break;
                                    case 5:
                                        result += "and fifty ";
                                        break;
                                    default:
                                        result += "and " + readNumber[tens] + "ty ";
                                }
                                if (units != 0) {
                                    result += readNumber[units];
                                }
                            }
                        }

                    }
                }
            }
        }
        if (result == "")
            System.out.println("Enter Small Number under 1000!");
        else
            System.out.println("Text: " + result);
    }
}