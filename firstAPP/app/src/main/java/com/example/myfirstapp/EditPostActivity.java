package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditPostActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etTitle,etBody;
    Button btnSave;
    FirebaseDatabase database;
    DatabaseReference postRef;

    String key;
    Post p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);

        database = FirebaseDatabase.getInstance();
        etTitle = (EditText) findViewById(R.id.etTitle);
        etBody = (EditText) findViewById(R.id.etBody);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);
        Intent intent = getIntent();

        key = intent.getExtras().getString("key");
        postRef = database.getReference("Post/" + key);
        this.retrieveData();

    }


    public void retrieveData()
    {
        postRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                p = dataSnapshot.getValue(Post.class);
                etBody.setText(p.body);
                etTitle.setText(p.title);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    @Override
    public void onClick(View v) {

        if(etTitle.getText().toString().length()>0&&
                etBody.getText().toString().length()>0)
        {
            postRef = database.getReference("Post/" + p.key);
            p.uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            p.title = etTitle.getText().toString();
            p.body = etBody.getText().toString();
            p.flg=true;
            postRef.setValue(p);


            finish();
        }
        else
            Toast.makeText(this, "please fill all fields", Toast.LENGTH_LONG).show();

    }
}