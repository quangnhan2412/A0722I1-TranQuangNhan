package ss12_java_collection_framework_map_tree.linkedlist_javacolection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManagerLinked {
    public static LinkedList<Product> linkedProduct = new LinkedList<>();

    static ProductComparatorAscending productComparatorAscending = new ProductComparatorAscending();
    static ProductComparatorDescending productComparatorDescending = new ProductComparatorDescending();
    static {
        linkedProduct.add(new Product(01, "My tom", 10000));
        linkedProduct.add(new Product(02, "Pho", 12000));
        linkedProduct.add(new Product(03, "Chao", 9000));
    }

    static Scanner scanner = new Scanner(System.in);

    protected static void addProduct() {
        boolean check = false;
        do {
            int index = -1;
            System.out.print("Enter new ID  : ");
            int id = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < linkedProduct.size(); i++) {
                if (linkedProduct.get(i).getId() == id) {
                    index = i;
                    check = false;
                }
            }
            if (index == -1 || linkedProduct.size() == 0)
                check = true;
            if (check) {
                System.out.print("Enter product: ");
                String name = scanner.nextLine();
                System.out.print("Enter price : ");
                int price = Integer.parseInt(scanner.nextLine());
                Product newProduct = new Product(id, name, price);
                linkedProduct.add(newProduct);
            } else {
                System.out.println("Invalid ID, please try again!");
            }
        } while (!check);
    }

    protected static void updateProduct() {
        System.out.println("Enter id cần update ? ");
        int index = -1;
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linkedProduct.size(); i++) {
            if (linkedProduct.get(i).getId() == id) {
                index = i;
                System.out.println("Ẹnter name update : ");
                String name = scanner.nextLine();
                System.out.println("Enter price update : ");
                int price = Integer.parseInt(scanner.nextLine());
                linkedProduct.get(index).setName(name);
                linkedProduct.get(index).setPrice(price);
                break;
            }
        }
        if (index == -1) {
            System.out.println("Invalid index, please try again!");
        }
    }

    protected static void searchProductByName() {
        int index = -1;
        System.out.println("Enter product search ");
        String name = scanner.nextLine();
        for (int i = 0; i < linkedProduct.size(); i++) {
            if (linkedProduct.get(i).getName() == name) {
                index = i;
                System.out.println("Product { " + " id= " + linkedProduct.get(i).getId()
                        + ",name='" + linkedProduct.get(i).getName() + '\''
                        + ", price = " + linkedProduct.get(i).getPrice() + '}');
            }
        }
        if (index == -1) {
            System.out.println("Invalid name, please try again!");
        }
    }
    protected  static void deleteProduct() {
        int index = -1;
        System.out.printf("Enter ID delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linkedProduct.size(); i++) {
            if (linkedProduct.get(i).getId() == id) {
                index = i;
                linkedProduct.remove(index);
            }
        }
        if (index == -1) {
            System.out.println("Invalid index, please try again!");
        }
    }
    protected static void displayProduct(){
        System.out.println("-----List of products-----");
        for (int i = 0; i < linkedProduct.size(); i++) {
            System.out.println(linkedProduct.get(i));
        }
        System.out.println("--------------------------");
    }
    protected void sortAscendingOrder() {
        Collections.sort(linkedProduct,productComparatorAscending);
        displayProduct();
    }
    protected void sortDescendingOrder() {
        Collections.sort(linkedProduct, productComparatorDescending);
        displayProduct();
    }
}