package ss17_io_binary_serialization.ex_product_stream;

import java.io.Serializable;

public class Product implements Serializable     {
    private int codeProduct   ;
    private String nameProduct;
    private String manufacturer;
    private double priceProduct;
    private String otherDescriptions;

    public Product() {
    }

    public Product(int codeProduct, String nameProduct, String manufacturer, double priceProduct, String otherDescriptions) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.manufacturer = manufacturer;
        this.priceProduct = priceProduct;
        this.otherDescriptions = otherDescriptions;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(int codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(String otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codeProduct=" + codeProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", priceProduct=" + priceProduct +
                ", otherDescriptions='" + otherDescriptions + '\'' +
                '}';
    }
}