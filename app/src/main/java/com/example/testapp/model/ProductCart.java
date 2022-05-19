package com.example.testapp.model;

public class ProductCart implements ProductInterface {

    private int id;
    private String img;
    private String name;
    private int price;
    private int quantity;

    public ProductCart(int id, String img, String name, int price, int quantity) {
        this. id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public void updateQuantity(int a) {
        this.quantity = quantity + a;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getImg() {
        return img;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String getProduct() {
        String str = "ID: " + id + " | NAME: " + name + " | PRICE: " + price + " | IMG: " + img + "| QUANTITY: " + quantity;
        return str;
    }
}
