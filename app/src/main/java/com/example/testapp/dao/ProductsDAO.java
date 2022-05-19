package com.example.testapp.dao;

import com.example.testapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {

    private static List<Product> list = new ArrayList<>();

    public ProductsDAO() {
        list.add(0, new Product(0, "pizza_peperoni", "Пицца Пепперони", 300, "Томатный соус, сыр моцарелла, пепперони, сыр пармезан", 100));
        list.add(1, new Product(1, "rolls_salmon_set", "Роллы с лососем", 200, "Порция 8шт. Лосось, сливочный сыр, соус унаги", 100));
        list.add(2, new Product(2, "burger_chiken_fresh", "Бургер Чикен Фреш", 150, null, 100));
        list.add(3, new Product(3, "french_fries", "Картофель Фри", 70, null, 100));
        list.add(4, new Product(4, "burger_barbeku", "Бургер Барбекю", 200, null, 100));
    }

    public static List getAll() {
        return list;
    }
    public static Product getById(int id) {
        return list.get(id);
    }
    public static Product getByName(String name) {
        try {
            return list.stream().filter(str -> str.getName().equals(name)).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }
    public static void create(Product product) {
        list.add(product);
    }
}
