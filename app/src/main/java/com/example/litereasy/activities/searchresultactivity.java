package com.example.litereasy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.litereasy.R;
import com.example.litereasy.adapter.artbookadapterrr;

import com.example.litereasy.adapter.searchresultadapter;
import com.example.litereasy.databinding.ActivitySearchresultactivityBinding;
import com.example.litereasy.models.artbookmodel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class searchresultactivity extends AppCompatActivity {
    ActivitySearchresultactivityBinding binding;
    DatabaseReference databaseReference;
    ArrayList<artbookmodel> list;
    searchresultadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        if (AppCompatDelegate.getDefaultNightMode() ==AppCompatDelegate.MODE_NIGHT_YES)
        {
            setTheme(R.style.Theme_Dark);

        }
        else {
            setTheme(R.style.Theme_Light);
        }
        binding = ActivitySearchresultactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String value = getIntent().getStringExtra("searchresult");

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Allbooks");
        binding.searchtextid.setLayoutManager(new LinearLayoutManager(searchresultactivity.this));
        list=new ArrayList<>();
        adapter=new searchresultadapter(searchresultactivity.this,list);
        binding.searchtextid.setAdapter(adapter);
        databaseReference.orderByChild("bookname").startAt(value).endAt(value + "\uf8ff").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    artbookmodel artbookmodell=dataSnapshot.getValue(com.example.litereasy.models.artbookmodel.class);
                    list.add(artbookmodell);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });


        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}