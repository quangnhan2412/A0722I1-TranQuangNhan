package ss12_java_collection_framework_map_tree.arraylist_javacolection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {


    private static ArrayList<Product> productList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

  static   ProductComparatorAscending productComparatorAscending = new ProductComparatorAscending();
   static   ProductComparatorDescending productComparatorDescending = new ProductComparatorDescending();

    static {
        productList.add(new Product(01, "My tom", 10.000));
        productList.add(new Product(02, "Pho", 12.000));
        productList.add(new Product(03, "Chao", 9.000));
    }

    public static Product inputProduct() {
        System.out.println("Enter id :");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product :");
        String product = scanner.nextLine();
        System.out.println("Enter price ");
        Double price = Double.parseDouble(scanner.nextLine());

        return new Product(id, product, price);
    }

    public static void displayALL() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }

    public static void add() {
        productList.add(inputProduct());
        displayALL();
    }

    public static void update(int ID) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == (ID)) {
                Product newProduct = inputProduct();
                productList.set(i, newProduct);
                break;
            } else {
                System.out.println("Not Found ! ");
                break;
            }
        }
    }

    public static void delete(int Id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == Id) {
                Id = i;
                productList.remove(Id);
                break;
            }
            if (Id == -1) {
                System.out.println("Not found ! ");
            }
        }
    }

    public static void search() {
        int index = -1;
        System.out.println("Enter product search ? ");
        String product = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProduct().equals(product)) {
                index = i;
                System.out.println("Product{" + "id=" + productList.get(i).getId()
                        + ", name='" + productList.get(i).getProduct() + '\''
                        + ", price=" + productList.get(i).getPrice() + '}');
                break;
            }
        }
        if (index == -1) {
            System.out.println("Not found ! ");
        }
    }
    //Giá tăng dần
    public static void sortAscendingOrder(){
        Collections.sort(productList,productComparatorAscending);
        displayALL();
    }
    //Giá giảm dần
    public static void sortDescendingOrder(){
        Collections.sort(productList,productComparatorDescending);
        displayALL();
    }
}


