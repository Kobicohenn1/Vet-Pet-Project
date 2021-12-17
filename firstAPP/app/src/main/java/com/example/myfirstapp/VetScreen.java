package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VetScreen extends AppCompatActivity implements View.OnClickListener {

    Button btnFell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_screen);

        btnFell=(Button)findViewById(R.id.btnSick);

        btnFell.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AllPostActivity.class);
        startActivity(intent);
    }
}