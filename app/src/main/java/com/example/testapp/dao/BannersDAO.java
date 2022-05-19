package com.example.testapp.dao;

import com.example.testapp.model.Banner;
import com.example.testapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class BannersDAO {

    private static List<Banner> list = new ArrayList<>();

    public BannersDAO() {
        list.add(0, new Banner(0, "first_banner", "First Banner"));
        list.add(1, new Banner(1, "first_banner", "First Banner"));
        list.add(2, new Banner(2, "first_banner", "First Banner"));
        list.add(3, new Banner(3, "first_banner", "First Banner"));
    }
    public static List getAll() {
        return list;
    }
    public static Banner getById(int id) {
        return list.get(id);
    }
    public static Banner getByName(String name) {
        try {
            return list.stream().filter(str -> str.getName().equals(name)).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }
    public static void create(Banner banner) {
        list.add(banner);
    }
}
