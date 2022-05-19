package com.example.testapp.model;

public class Product implements ProductInterface {

    private int id;
    private String img;
    private String name;
    private int price;
    private String composition;
    private int rating;

    public Product(int id, String img, String name, int price, String composition, int rating) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.composition = composition;
        this.rating = rating;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String getImg() {
        return img;
    }
    @Override
    public void setImg(String img) {
        this.img = img;
    }
    @Override
    public String getProduct() {
        String str = "ID: " + id + " | NAME: " + name + " | PRICE: " + price + " | IMG: " + img;
        return str;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
