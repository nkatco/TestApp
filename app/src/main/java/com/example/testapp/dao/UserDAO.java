package com.example.testapp.dao;

import com.example.testapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static List<User> list = new ArrayList<>();

    public UserDAO() {
        list.add(0, new User(0, "admin", "admin", "admin"));
        list.add(1, new User(1, "user", "user", "user"));
    }

    public List getAll() {
        return list;
    }
    public User getById(int id) {
        return list.get(id);
    }
    public static User getByLogin(String login) {
        try {
            return list.stream().filter(str -> str.getLogin().equals(login)).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }
    public static void create(User user) {
        list.add(user);
    }
}
