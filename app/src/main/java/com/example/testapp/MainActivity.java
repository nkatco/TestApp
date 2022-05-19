package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp.dao.BannersDAO;
import com.example.testapp.dao.ProductsDAO;
import com.example.testapp.dao.UserDAO;
import com.example.testapp.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button loginButton;
    private TextView OnRegisterText;
    private TextView TextLogin;
    private TextView TextPassword;

    private UserDAO userDAO = new UserDAO();
    private ProductsDAO productsDAO = new ProductsDAO();
    private BannersDAO bannersDAO = new BannersDAO();

    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        TextLogin = findViewById(R.id.RegisterTextLogin);
        TextPassword = findViewById(R.id.RegisterTextPassword);
        OnRegisterText = findViewById(R.id.OnRegisterText);

        TextLogin.setText("admin");
        TextPassword.setText("admin");

        loginButton.setOnClickListener(this);
        OnRegisterText.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginButton:
                Thread mThread = new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Thread run");
                                if (TextLogin.getText() != null && !TextLogin.getText().equals("") &&
                                        TextPassword.getText() != null && !TextPassword.getText().equals("")) {
                                    user = userDAO.getByLogin(String.valueOf(TextLogin.getText()));
                                    if (user != null) {
                                        if (String.valueOf(TextPassword.getText()).equals(user.getPassword())) {
                                            System.out.println("Login successful");
                                            Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                                            startActivity(intent);
                                        } else {
                                            sendToast("Пароль неверный");
                                            System.out.println("Password incorrect");
                                        }
                                    } else {
                                        sendToast("Логин не найден");
                                        System.out.println("Login incorrect");
                                    }
                                } else {
                                    sendToast("Вы не ввели логин или пароль");
                                    System.out.println("TextLogin or TextPassword = null");
                                }
                            }
                        }
                ); mThread.start(); break;
            case R.id.OnRegisterText:
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
        }
    }
    private void sendToast(String msg) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}