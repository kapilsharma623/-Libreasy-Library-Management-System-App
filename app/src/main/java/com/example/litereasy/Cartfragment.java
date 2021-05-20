package com.example.litereasy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.litereasy.adapter.allbooksadapter;
import com.example.litereasy.models.allbooksmodel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Cartfragment extends Fragment {

    RecyclerView recyclerView;
    allbooksadapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cartfragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.allbookrecyclerview);

        //allbooks
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        FirebaseRecyclerOptions<allbooksmodel> options =
                new FirebaseRecyclerOptions.Builder<allbooksmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Allbooks"), allbooksmodel.class)
                        .build();
        adapter = new allbooksadapter(options);
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}