package com.example.myfirstapp;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClientScreenMain extends AppCompatActivity implements View.OnClickListener {
    private TextView welcome;
    private Button btnAdd,btnLife,btnFaq;
    private Button logout;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_screen_main);

        welcome=(TextView) findViewById(R.id.welcomeClient);
        btnAdd=(Button)findViewById(R.id.btn_Add);
        logout=(Button)findViewById(R.id.btnLogOutClient);
        btnLife=(Button)findViewById(R.id.btn_Health) ;
        btnFaq=(Button)findViewById(R.id.btn_Faq) ;

        firebaseAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();// this user

        btnAdd.setOnClickListener(this);
        logout.setOnClickListener(this);
        btnLife.setOnClickListener(this);
        btnFaq.setOnClickListener(this);

        reference= FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("fullname").getValue().toString();
                welcome.setText("Welcome: "+""+name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        if (btnAdd==v)
        {
            startActivity(new Intent(this,AddAnimal.class));
        }
        if(btnLife==v)
        {
            startActivity(new Intent(this,HealthLifeTips.class));
        }
        if(btnFaq==v)
        {
            startActivity(new Intent(this,FAQUser.class));

        }
        if (logout==v)
        {
            firebaseAuth.signOut();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}