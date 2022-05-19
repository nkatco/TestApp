package com.example.testapp.model;

public interface ProductInterface {
    int getId();
    String getImg();
    String getName();
    int getPrice();

    String getProduct();

    void setId(int id);
    void setImg(String img);
    void setName(String name);
    void setPrice(int price);
}
