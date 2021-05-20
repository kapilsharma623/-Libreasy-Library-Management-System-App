package com.example.litereasy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.litereasy.databinding.ActivitySplashscreenactivityBinding;

public class Splashscreenactivity extends AppCompatActivity {
ActivitySplashscreenactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySplashscreenactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        Thread thread=new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();

                }finally {
                    Intent intent=new Intent(Splashscreenactivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();
    }
}