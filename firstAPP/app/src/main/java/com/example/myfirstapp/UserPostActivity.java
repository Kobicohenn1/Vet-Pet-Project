package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserPostActivity extends AppCompatActivity {


    ListView lv;
    ArrayList<Post> posts;
    AllPostAdapter allPostAdapter;
    private DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_post_activity);

        database = FirebaseDatabase.getInstance().getReference("Post");
        lv = (ListView)findViewById(R.id.lv);
        this.retriveData();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post p = posts.get(position);
                Intent intent = new Intent(UserPostActivity.this, EditPostActivity.class);
                intent.putExtra("key", p.key);
                startActivity(intent);
            }
        });


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Post p = posts.get(position);
                DatabaseReference current = FirebaseDatabase.getInstance().getReference("Post");
                current.removeValue();
                return true;


            }
        });
    }

    public void retriveData()
    {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //String id=dataSnapshot.child("uid").getValue().toString();
                String uid= FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
                    posts = new ArrayList<Post>();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Post p = data.getValue(Post.class);

                            posts.add(p);
                        if (p.uid.equals(uid)) {
                            allPostAdapter = new AllPostAdapter(UserPostActivity.this, 0, 0, posts);
                            lv.setAdapter(allPostAdapter);
                        }
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}





