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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.litereasy.activities.Adminactivity;
import com.example.litereasy.adapter.userrecordadapter;
import com.example.litereasy.models.userrecord;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class soldbookfragment extends Fragment {

   ImageView imageView;
   TextView userid;
   Button button;
   DatabaseReference database;
    DatabaseReference database2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_soldbookfragment, container, false);

        imageView=(ImageView)view.findViewById(R.id.backbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Adminactivity.class));
            }
        });
        button=view.findViewById(R.id.DeleteBook);
        userid=view.findViewById(R.id.tvuserid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useridd=userid.getText().toString();
                if (!useridd.isEmpty())
                {
                    database=FirebaseDatabase.getInstance().getReference().child("Allusers");
                    database.child(useridd).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            snapshot.getRef().removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getContext(),"User deleted Successfully",Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull @NotNull Exception e) {
                                    Toast.makeText(getContext(),"User deletion Failed",Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });

                    database2=FirebaseDatabase.getInstance().getReference().child("Existingusers");
                    database2.child(useridd).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            snapshot.getRef().removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getContext(),"User deleted Successfully",Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull @NotNull Exception e) {
                                    Toast.makeText(getContext(),"User deletion Failed",Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });
                }
                else {
                    userid.setError("Enter User Id");
                }
            }
        });
        return view;
    }

}