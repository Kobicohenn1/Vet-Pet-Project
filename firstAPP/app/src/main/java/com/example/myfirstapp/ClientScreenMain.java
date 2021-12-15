package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;

public class ClientScreenMain extends AppCompatActivity implements View.OnClickListener {
    private TextView welcome;
    private Button btnAdd;
    User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_screen_main);

        welcome=(TextView) findViewById(R.id.welcomeClient);
        btnAdd=(Button)findViewById(R.id.btn_Add);

        welcome.setText("welcome:"+"");


        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (btnAdd==v)
        {
            startActivity(new Intent(getApplicationContext(),AddAnimal.class));

        }
    }
}