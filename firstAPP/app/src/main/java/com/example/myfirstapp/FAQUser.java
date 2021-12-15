package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FAQUser extends AppCompatActivity implements View.OnClickListener {
    Button btnDogEat;
    Button btnDogBurn;
    Button btnDogBit;
    Button btnDogTreatments;
    Button btnDogNeutering;
    Button btnDogTrain;
    Button btnCatVaccine;
    Button btnCatWash;
    Button btnCatMarch;
    Button btnCatEat;
    Button btnCatMilk;
    Button btnCatPoop;
//    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faquser);

        btnDogEat = (Button)findViewById(R.id.btnDogEat);
        btnDogBurn = (Button)findViewById(R.id.btnDogBurn);
        btnDogBit = (Button)findViewById(R.id.btnDogBit);
        btnDogTreatments = (Button)findViewById(R.id.btnDogTreatments);
        btnDogNeutering = (Button)findViewById(R.id.btnDogNeutering);
        btnDogTrain = (Button)findViewById(R.id.btnDogTrain);
        btnCatVaccine = (Button)findViewById(R.id.btnCatVaccine);
        btnCatWash = (Button)findViewById(R.id.btnCatWash);
        btnCatMarch = (Button)findViewById(R.id.btnCatMarch);
        btnCatEat = (Button)findViewById(R.id.btnCatEat);
        btnCatMilk = (Button)findViewById(R.id.btnCatMilk);
        btnCatPoop = (Button)findViewById(R.id.btnCatPoop);

        btnDogEat.setOnClickListener(this);
        btnDogBurn.setOnClickListener(this);
        btnDogBit.setOnClickListener(this);
        btnDogTreatments.setOnClickListener(this);
        btnDogNeutering.setOnClickListener(this);
        btnDogTrain.setOnClickListener(this);
        btnCatVaccine.setOnClickListener(this);
        btnCatWash.setOnClickListener(this);
        btnCatMarch.setOnClickListener(this);
        btnCatEat.setOnClickListener(this);
        btnDogEat.setOnClickListener(this);
        btnCatMilk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDogEat:
                Toast.makeText(this, "כל כלב הוא עולם ומלאו! חשוב לאבחן אם יש סיבה רגשית לעובדה שהוא לא אוכל. אם זה כלב חדש שהגיע הביתה אז אולי הוא עדיין בסטרס ומנסה להתאקלם. אולי יש לו מצב רוח ירוד בגלל איזשהו שינוי בבית, בשגרה וכו'... אני ממליצה להיעזר באיש מקצוע על מנת לנסות להגיע לסיבה לחוסר התיאבון של הכלב.", Toast.LENGTH_LONG).show();
                break;
        }
    }
}