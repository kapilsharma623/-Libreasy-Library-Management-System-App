package com.example.litereasy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.litereasy.adapter.duesadapter;
import com.example.litereasy.databinding.ActivityDuebookkkBinding;


import com.example.litereasy.models.duesmodel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class duebookkk extends AppCompatActivity {
    ActivityDuebookkkBinding binding;
    DatabaseReference databaseReference;
    ArrayList<duesmodel> list;
    com.example.litereasy.adapter.duesadapter duesadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDuebookkkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        String userid=getIntent().getStringExtra("useriiid");
        binding.textt.setText(userid);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Allusers").child(userid);
        binding.duebookkrecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        list=new ArrayList<>();
        duesadapter=new duesadapter(getApplicationContext(),list);
        binding.duebookkrecyclerview.setAdapter(duesadapter);

        /*databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    duesmodel duesmodel=dataSnapshot.getValue(duesmodel.class);
                    list.add(duesmodel);
                }
                duesadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });*/

        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}