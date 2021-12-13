package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddAnimal extends AppCompatActivity implements View.OnClickListener {

    private EditText breed,age,weight;
    private Button btnDog,btnCat,btnConfirm;

    boolean clickCat=false;
    boolean clickDog=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        breed=(EditText) findViewById(R.id.editBreed);
        age=(EditText) findViewById(R.id.editAge);
        weight=(EditText) findViewById(R.id.editWeight);

        btnDog=(Button) findViewById(R.id.btnDog);
        btnCat=(Button) findViewById(R.id.btnCat);
        btnConfirm=(Button) findViewById(R.id.btnConfirm);

        btnDog.setOnClickListener(this);
        btnCat.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (btnCat==v)
        {
            clickCat=true;
            clickDog=false;
        }
        if (btnDog==v)
        {
            clickCat=false;
            clickDog=true;
        }
        if(btnConfirm==v)
        {

                addDataAnimel();
        }


    }

    private void addDataAnimel()
    {
        String strBreed=breed.getText().toString().trim();
        String strAge=age.getText().toString().trim();
        String strWeight=weight.getText().toString().trim();

        if (strBreed.isEmpty())
        {
            breed.setError("Enter Breed");
            breed.requestFocus();
            return;
        }
        if (strAge.isEmpty())
        {
            age.setError("Enter Age");
            age.requestFocus();
            return;
        }
        if (strWeight.isEmpty())
        {
            breed.setError("Enter Weight");
            breed.requestFocus();
            return;
        }

        if((clickCat==true)||(clickDog==true))
        {
            if(clickCat==true)
            {
                Cat cat=new Cat(strBreed,strAge,strWeight);
            }
            if(clickDog=true)
            {
                Dog dog=new Dog(strBreed,strAge,strWeight);
            }
        }



    }
}