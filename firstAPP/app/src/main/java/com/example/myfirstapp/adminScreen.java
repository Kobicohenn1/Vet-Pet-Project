package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class adminScreen extends AppCompatActivity implements View.OnClickListener {
    Button btnLogout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
        mAuth = FirebaseAuth.getInstance();

        btnLogout=(Button) findViewById(R.id.btnLogOutAdmin);
        btnLogout.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==btnLogout)
        {
            mAuth.signOut();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}