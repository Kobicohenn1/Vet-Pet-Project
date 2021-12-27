package com.example.myfirstapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetreiveDataActivity extends AppCompatActivity {

    ListView myListview;
    List<Vet> vetList;

    DatabaseReference VetDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreive_data);

        myListview = findViewById(R.id.myListView);
        vetList = new ArrayList<>();

        VetDbRef = FirebaseDatabase.getInstance().getReference("Vet");

        VetDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                vetList.clear();
                for (DataSnapshot VetDataSnap : snapshot.getChildren())
                {
                    Vet vet = VetDataSnap.getValue(Vet.class);
                    vetList.add(vet);
                }
                ListAdapter adapter = new ListAdapter(RetreiveDataActivity.this,vetList);
                myListview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}