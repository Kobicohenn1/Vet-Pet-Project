package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button RegAsVet;
    Button RegAsClient;
    Button ClickLogIn;
    Button ClickLogInVet;
    Button ClickLogInAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RegAsVet = (Button)findViewById(R.id.btn_registerVet);
        RegAsClient = (Button)findViewById(R.id.btn_registerClient);
        ClickLogIn = (Button) findViewById(R.id.btn_login);
        ClickLogInVet = (Button) findViewById(R.id.btn_loginVET);
        ClickLogInAdmin = (Button)findViewById(R.id.btn_loginAdmin);

        RegAsClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegClientActivity();
            }
        });

        RegAsVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegVetActivity();
            }
        });

        ClickLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLoginActivity();
            }
        });

        ClickLogInVet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegVetActivityVet();
            }
        });
        ClickLogInAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               OpenLogInAdminActivity();
            }
        });
    }

    public void OpenRegClientActivity(){
        Intent intentClient = new Intent(this,RegClientActivity.class);
        startActivity(intentClient);
    }

    public void OpenRegVetActivity(){
        Intent intentVet = new Intent(this,RegVetActivity.class);
        startActivity(intentVet);
    }

    public void OpenLoginActivity(){
        Intent intentLogin = new Intent(this,LoginActivity.class);
        startActivity(intentLogin);
    }

    public void OpenRegVetActivityVet(){
        Intent intentLoginVet = new Intent(this,LoginActivityVet.class);
        startActivity(intentLoginVet);
    }

    public void OpenLogInAdminActivity()
    {
        Intent intentLoginAdmin = new Intent(this,Admin_Login.class);
        startActivity(intentLoginAdmin);
    }
}