package com.example.litereasy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.litereasy.R;
import com.example.litereasy.databinding.ActivitySearchbookonclickBinding;

public class searchbookonclick extends AppCompatActivity {
ActivitySearchbookonclickBinding binding;
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

        binding=ActivitySearchbookonclickBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(searchbookonclick.this,MainActivity.class));
            }
        });
        binding.booknameidd.setText(getIntent().getStringExtra("bookname"));
        binding.booknameid.setText(getIntent().getStringExtra("bookname"));
        binding.bookauthoridd.setText(getIntent().getStringExtra("bookauthor"));
        binding.booksubjectidd.setText(getIntent().getStringExtra("booksubject"));
        binding.bookidd.setText(getIntent().getStringExtra("bookid"));
        binding.bookquantityidd.setText(getIntent().getStringExtra("bookquantity"));
        binding.bookdescriptionidd.setText(getIntent().getStringExtra("bookdescription"));
        String imagee=getIntent().getStringExtra("bookimage");
        Glide.with(getApplicationContext()).load(imagee).into(binding.bookimagesource);

    }
}