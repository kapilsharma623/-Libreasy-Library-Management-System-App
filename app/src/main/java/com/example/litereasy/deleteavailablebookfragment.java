package com.example.litereasy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.litereasy.databinding.FragmentBookdetailsonclickfragmentBinding;
import com.example.litereasy.databinding.FragmentDeleteavailablebookfragmentBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;


public class deleteavailablebookfragment extends Fragment {
    FragmentDeleteavailablebookfragmentBinding binding;
    DatabaseReference database;
    DatabaseReference databaseReference;
    String bookid,bookimage,booknamee,bookauthorr,booksubjectt,bookquantityy,bookdescriptionn;
    public deleteavailablebookfragment() {

    }
    public deleteavailablebookfragment(String bookid, String bookimage, String booknamee, String bookauthorr, String booksubjectt, String bookquantityy, String bookdescriptionn) {
        this.bookid = bookid;
        this.bookimage = bookimage;
        this.booknamee = booknamee;
        this.bookauthorr = bookauthorr;
        this.booksubjectt = booksubjectt;
        this.bookquantityy = bookquantityy;
        this.bookdescriptionn = bookdescriptionn;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDeleteavailablebookfragmentBinding.inflate(getLayoutInflater());
        database= FirebaseDatabase.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity=(AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.deleteavailablebook, new availablebookfragment()).addToBackStack(null).commit();

            }
        });
        binding.booknameid.setText(booknamee);
        binding.bookauthoridd.setText(bookauthorr);
        binding.booksubjectidd.setText(booksubjectt);
        binding.bookquantityidd.setText(bookquantityy);
        binding.bookdescriptionidd.setText(bookdescriptionn);
        binding.booknameidd.setText(booknamee);
        binding.bookidd.setText(bookid);
        Glide.with(getContext()).load(bookimage).into(binding.bookimagesource);

        binding.deletebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database.child("Allbooks").child(bookid).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            snapshot.getRef().removeValue();
                        }
                        AppCompatActivity activity=(AppCompatActivity)getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.deleteavailablebook, new availablebookfragment()).addToBackStack(null).commit();

                        Toast.makeText(getContext(),"Book deleted Successfully",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });

                databaseReference.child(booksubjectt).child(bookid).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot1:snapshot.getChildren())
                        {
                            snapshot.getRef().removeValue();
                        }
                        AppCompatActivity activity=(AppCompatActivity)getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.deleteavailablebook, new availablebookfragment()).addToBackStack(null).commit();
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });

            }
        });

        return binding.getRoot();
    }
    public void onBackpressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.deleteavailablebook, new availablebookfragment()).addToBackStack(null).commit();
    }
}