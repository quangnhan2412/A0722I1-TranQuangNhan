package ss12_java_collection_framework_map_tree.arraylist_javacolection;

import java.util.Scanner;

public class Main {
    static int choice = -1;
    static Scanner scanner = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        ProductManager product = new ProductManager();
        System.out.println("1.\tDisplay list Product");
        System.out.println("2.\tAdd new Product");
        System.out.println("3.\tEdit Product");
        System.out.println("4.\tDelete Product");
        System.out.println("5.\tSearch Product");
        System.out.println("6.\tProducts decrease in price( giảm dần)");
        System.out.println("7.\tProducts increase in price (tăng dần)");
        System.out.println(" ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                productManager.displayALL();
                break;
            case 2:
                productManager.add();
                break;
            case 3:
                product.displayALL();
                System.out.println("Enter id Id : ");
                Scanner scanner = new Scanner(System.in);
                Integer productID = scanner.nextInt();
                System.out.println(productID);
                product.update(productID);
                product.displayALL();
                break;
            case 4:
                product.displayALL();
                System.out.println("Enter id Id : ");
                Scanner sc = new Scanner(System.in);
                int delProductID = sc.nextInt();
                product.delete(delProductID);
                product.displayALL();

                break;
            case 5:
                productManager.displayALL();
                productManager.search();

                break;
            case 6:
               productManager.sortDescendingOrder();

                break;
            case 7:
                productManager.sortAscendingOrder();
                break;
            default:
                System.out.println("No choice!");
        }
    }
/*
Comparable and comparator chưa biết cách làm
 */

}
