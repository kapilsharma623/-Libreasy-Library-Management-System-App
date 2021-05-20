package com.example.litereasy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.litereasy.R;
import com.example.litereasy.SharedPref;
import com.example.litereasy.databinding.ActivityAdminactivityBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Adminactivity extends AppCompatActivity {
ActivityAdminactivityBinding binding;
DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            setTheme(R.style.Theme_Dark);
        }
        else {
            setTheme(R.style.Theme_Light);
        }
        binding= ActivityAdminactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportActionBar().hide();
        reference= FirebaseDatabase.getInstance().getReference().child("admin");
        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), adminpage.class));
            }
        });
        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username,password;
                username=binding.adminusername.getText().toString();
                password=binding.adminpassword.getText().toString();
                if(!username.isEmpty() && !password.isEmpty() )
                {
                    reference.orderByChild("username").equalTo(username).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists())
                            {
                                Toast.makeText(getApplicationContext(),"Admin Mode ON !",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),adminpage.class));
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Admin UserName and Password is not Valid !",Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getApplicationContext(),"Admin UserName and Password is not Valid !",Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else {
                    Toast.makeText(getApplicationContext(),"Fill UserName and Password !",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));

    }
}