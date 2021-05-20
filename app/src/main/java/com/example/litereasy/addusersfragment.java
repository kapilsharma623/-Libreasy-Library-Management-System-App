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
import com.example.litereasy.databinding.FragmentAddusersfragmentBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class addusersfragment extends Fragment {
    FragmentAddusersfragmentBinding binding;
    DatabaseReference refer;
    DatabaseReference refer2;
    DatabaseReference refer3;
    DatabaseReference refer4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentAddusersfragmentBinding.inflate(getLayoutInflater());
        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Adminactivity.class));
            }
        });
        binding.tvsubmitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,email,phone,address,bookid,bookname,quantity,date,duedate;
                name=binding.tvusername.getText().toString();
                email=binding.tvemailid.getText().toString();
                phone=binding.tvphoneno.getText().toString();
                address=binding.tvaddress.getText().toString();
                bookid=binding.tvbookid.getText().toString();
                bookname=binding.tvbookname.getText().toString();
                quantity=binding.tvquantity.getText().toString();
                date=binding.tvdate.getText().toString();
                duedate=binding.tvduedate.getText().toString();
                refer= FirebaseDatabase.getInstance().getReference().child("Allusers");
                String userid=refer.push().getKey();
                HashMap<String,Object> dataa=new HashMap<>();
                dataa.put("userid",userid);
                dataa.put("name",name);
                dataa.put("email",email);
                dataa.put("phone",phone);
                dataa.put("address",address);
                dataa.put("bookid",bookid);
                dataa.put("bookname",bookname);
                dataa.put("quantity",quantity);
                dataa.put("date",date);
                dataa.put("duedate",duedate);
                HashMap<String,Object> existdata=new HashMap<>();
                existdata.put("bookid",bookid);
                existdata.put("bookname",bookname);
                existdata.put("date",date);
                existdata.put("duedate",duedate);
                existdata.put("quantity",quantity);
                HashMap<String,Object> existiddata=new HashMap<>();
                existiddata.put("userid",userid);
                existiddata.put("name",name);

                //addnewusermodel newuser=new addnewusermodel(userid,name,email,phone,address,bookid,bookname,quantity,date,duedate);
                refer2= FirebaseDatabase.getInstance().getReference().child("Allusers");
                refer3=FirebaseDatabase.getInstance().getReference().child("Existingusers");
                refer4=FirebaseDatabase.getInstance().getReference().child("Existingusers");
                if(name.isEmpty() && email.isEmpty() && phone.isEmpty() && address.isEmpty() && bookid.isEmpty() && bookname.isEmpty() &&
                quantity.isEmpty() && date.isEmpty() && duedate.isEmpty())
                {
                    Toast.makeText(getContext(),"Fill All Details",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    refer2.child(userid).setValue(dataa).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getContext(),"New User Added to Database",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(getContext(),"Failed to Add",Toast.LENGTH_SHORT).show();
                        }
                    });
                    refer4.child(userid).setValue(existiddata).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            refer3.child(userid).push().setValue(existdata).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getContext(),"New User Added to Database",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull @NotNull Exception e) {
                                    Toast.makeText(getContext(),"Failed to Add",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(getContext(),"Failed to Add",Toast.LENGTH_SHORT).show();
                        }
                    });


                }


            }
        });

        return binding.getRoot();
    }
}