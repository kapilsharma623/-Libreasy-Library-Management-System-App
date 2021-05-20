package com.example.litereasy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.litereasy.activities.Adminactivity;
import com.example.litereasy.databinding.FragmentExistinguserfragmentBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class existinguserfragment extends Fragment {
FragmentExistinguserfragmentBinding binding;
    DatabaseReference databaseReference;
    public existinguserfragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentExistinguserfragmentBinding.inflate(getLayoutInflater());
        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Adminactivity.class));
            }
        });
        binding.AddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useridd=binding.tvuserrrid.getText().toString();
                String bookid=binding.tvbookkid.getText().toString();
                String date=binding.tvddate.getText().toString();
                String tvbookname=binding.tvbookname.getText().toString();
                String tvbookquantity=binding.tvbookquantity.getText().toString();
                String duedate=binding.tvdueedate.getText().toString();
                HashMap<String,Object> existdata=new HashMap<>();
                existdata.put("bookid",bookid);
                existdata.put("bookname",tvbookname);
                existdata.put("date",date);
                existdata.put("duedate",duedate);
                existdata.put("quantity",tvbookquantity);
                if (!useridd.isEmpty() && !bookid.isEmpty() && !date.isEmpty() && !duedate.isEmpty())
                {
                    databaseReference=FirebaseDatabase.getInstance().getReference().child("Existingusers");
                    databaseReference.child(useridd).push().setValue(existdata).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getContext(),"Book added to Existing User",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(getContext(),"Failed to Add",Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else
                {
                    Toast.makeText(getContext(),"Fill All Details",Toast.LENGTH_SHORT).show();
                }
            }
        });



        return binding.getRoot();

    }
}