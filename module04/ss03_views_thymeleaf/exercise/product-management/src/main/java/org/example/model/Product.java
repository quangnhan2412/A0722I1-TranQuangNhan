package org.example.model;

import java.util.Date;

public class Product {
    private int idProduct;
    private String nameProduct;
    private String caloProduct;
    private String  dairyIngredientsProduct;
    private String expProduct;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, String caloProduct, String dairyIngredientsProduct, String expProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.caloProduct = caloProduct;
        this.dairyIngredientsProduct = dairyIngredientsProduct;
        this.expProduct = expProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCaloProduct() {
        return caloProduct;
    }

    public void setCaloProduct(String caloProduct) {
        this.caloProduct = caloProduct;
    }

    public String getDairyIngredientsProduct() {
        return dairyIngredientsProduct;
    }

    public void setDairyIngredientsProduct(String dairyIngredientsProduct) {
        this.dairyIngredientsProduct = dairyIngredientsProduct;
    }

    public String getExpProduct() {
        return expProduct;
    }

    public void setExpProduct(String expProduct) {
        this.expProduct = expProduct;
    }
}
