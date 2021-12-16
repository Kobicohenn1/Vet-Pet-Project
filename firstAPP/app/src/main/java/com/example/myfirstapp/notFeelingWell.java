package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class notFeelingWell extends AppCompatActivity implements View.OnClickListener {


    EditText etTitle, etBody;
    Button btnSave;
    FirebaseUser user;

    FirebaseDatabase database;
    DatabaseReference myRef;

    Post p;
    boolean btnC=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_feeling_well);

        database=FirebaseDatabase.getInstance();
        etTitle = (EditText) findViewById(R.id.EDITsub);
        etBody = (EditText) findViewById(R.id.editBody);
        btnSave = (Button) findViewById(R.id.saveNFW);
        btnSave.setOnClickListener(this);


        user = FirebaseAuth.getInstance().getCurrentUser();// this user





    }


    public void retrieveData() {

        String title=etTitle.getText().toString().trim();
        String body=etBody.getText().toString().trim();

        if (title.isEmpty())
        {
            etTitle.setError("Enter Title");
            etTitle.requestFocus();
            return;
        }
        if (body.isEmpty())
        {
            etBody.setError("Enter Body Text");
            etBody.requestFocus();
            return;
        }

            Post p1 = new Post(body, title);
            myRef = database.getReference("Post");

            DatabaseReference postRef = database.getReference("Users");

        postRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Post")
                    .setValue(p1).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Send", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(getApplicationContext(), ClientScreenMain.class));

                    }
                }
            });
     //   postRef = database.getReference("User" );
//
//        p1.title = etTitle.getText().toString();
//        p1.body = etBody.getText().toString();
//        postRef.setValue(p1);
//
//        finish();




    }

    @Override
    public void onClick(View v) {
        if (btnSave == v) {
            retrieveData();
        }





    }

}



