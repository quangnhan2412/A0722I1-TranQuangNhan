package ss17_io_binary_serialization.ex_product_stream;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String URL = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\ss17_io_binary_serialization\\ex_product_stream\\File";
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(001, "Oxy", "VietNam", 25.000, "Rua Mat"));
        productList.add(new Product(002, "Simple", "Korea", 35.000, "Tay Trang"));
        productList.add(new Product(003, "Nevia", "Nhat", 75.000, "Kem chong nang"));

    }


    public static Product infoProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter code product :");
        int codeProduct = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name product :");
        String nameProduct = scanner.nextLine();
        System.out.println("Enter manufacturer : ");
        String manufacturer = scanner.nextLine();
        System.out.println("Enter price product : ");
        double priceProduct = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter other Descriptions : ");
        String otherDescriptions = scanner.nextLine();
        return new Product(codeProduct, nameProduct, manufacturer, priceProduct, otherDescriptions);
    }

    public static void addProduct() {
        productList.add(infoProduct());
        display();
    }

    public static void display() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void search(int codeProduct) {
        boolean isExits = false;
        for (Product product : productList) {
            if (product.getCodeProduct() == codeProduct) {
                System.out.println(product);
                isExits = true;
                break;
            }
        }

        if (!isExits) {
            System.out.println("Not found !");
        }
    }

    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFormFile(String path) throws IOException {
        List<Product> productList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //Ep Kieu
            productList = (List<Product>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static void main(String[] args) throws IOException {
        readDataFormFile(URL);
//        Scanner scanner = new Scanner(System.in);
//        writeToFile(URL, productList);
//
//        readDataFormFile(URL);
//        display();
//        System.out.println("Add new product  ");
//        addProduct();
//        writeToFile(URL, productList);
//        System.out.println("==================");
//        display();
//        System.out.println("Search id List : ");
//        int searchCodeProduct = Integer.parseInt(scanner.nextLine());
//        System.out.println(searchCodeProduct);
//        search(searchCodeProduct);
    }
}
