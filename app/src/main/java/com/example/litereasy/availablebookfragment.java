package com.example.litereasy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.litereasy.activities.Adminactivity;
import com.example.litereasy.adapter.availablebookadapter;
import com.example.litereasy.models.allbooksmodel;
import com.example.litereasy.models.artbookmodel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class availablebookfragment extends Fragment {
    RecyclerView recyclerView;
    ImageView backbtn;
    availablebookadapter availablebookadapter;
    ArrayList<artbookmodel> list;
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_availablebookfragment, container, false);
        backbtn=view.findViewById(R.id.backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Adminactivity.class));
            }
        });
        recyclerView=(RecyclerView)view.findViewById(R.id.availablebookrecyclerview);
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Allbooks");
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        list=new ArrayList<>();
        availablebookadapter=new availablebookadapter(view.getContext(),list);
        recyclerView.setAdapter(availablebookadapter);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren())
                {
                    artbookmodel artbookmodel=snapshot1.getValue(com.example.litereasy.models.artbookmodel.class);
                    list.add(artbookmodel);
                }
                availablebookadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });



        return view;
    }
   

}