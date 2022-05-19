package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapp.dao.UserDAO;
import com.example.testapp.model.User;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {

    private Button RegisterButton;
    private TextView RegisterTextNickname;
    private TextView RegisterTextLogin;
    private TextView RegisterTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        RegisterButton = findViewById(R.id.RegisterButton);
        RegisterTextNickname = findViewById(R.id.RegisterTextNickname);
        RegisterTextLogin = findViewById(R.id.RegisterTextLogin);
        RegisterTextPassword = findViewById(R.id.RegisterTextPassword);

        RegisterButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.RegisterButton:
                Thread mThread2 = new Thread (
                        new Runnable() {
                            @Override
                            public void run() {
                                if (String.valueOf(RegisterTextNickname.getText()) != null && !String.valueOf(RegisterTextNickname.getText()).equals("")
                                        && String.valueOf(RegisterTextLogin.getText()) != null && !String.valueOf(RegisterTextLogin.getText()).equals("")
                                        && String.valueOf(RegisterTextPassword.getText()) != null && !String.valueOf(RegisterTextPassword.getText()).equals("")) {
                                    String nickname = String.valueOf(RegisterTextNickname.getText());
                                    String login = String.valueOf(RegisterTextLogin.getText());
                                    String password = String.valueOf(RegisterTextPassword.getText());
                                    User user2 = UserDAO.getByLogin(login);
                                    if (user2 == null) {
                                        User user = new User(0, nickname, login, password);
                                        UserDAO.create(user);
                                        Intent intent = new Intent(ActivityTwo.this, MainActivity.class);
                                        startActivity(intent);
                                    } else if (user2 != null) {
                                        sendToast("Данный пользователь уже существует");
                                    }
                                } else {
                                    sendToast("Вы не ввели данные");
                                }
                            }
                        }
                );
                mThread2.start();
                break;
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