package com.example.litereasy.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.litereasy.Cartfragment;
import com.example.litereasy.Homefragment;
import com.example.litereasy.R;
import com.example.litereasy.SharedPref;
import com.example.litereasy.Userfragment;
import com.example.litereasy.databinding.ActivityMainBinding;
import com.example.litereasy.duesfragment;
import com.fxn.OnBubbleClickListener;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    public static String yes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();


        if (AppCompatDelegate.getDefaultNightMode() ==AppCompatDelegate.MODE_NIGHT_YES)
        {
           setTheme(R.style.Theme_Dark);
            binding.floatdarkbar.setVisibility(View.GONE);
            binding.floatlightbar.setVisibility(View.VISIBLE);

        }
        else {
           setTheme(R.style.Theme_Light);
            binding.floatlightbar.setVisibility(View.GONE);
            binding.floatdarkbar.setVisibility(View.VISIBLE);
        }


        FragmentTransaction homeTrans=getSupportFragmentManager().beginTransaction();
        homeTrans.replace(R.id.content,new Homefragment());
        homeTrans.commit();

        binding.bottomnavigation.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {
                switch(i)
                {
                    case R.id.newcollections:
                        FragmentTransaction homeTrans=getSupportFragmentManager().beginTransaction();
                        homeTrans.replace(R.id.content,new Homefragment());
                        homeTrans.commit();
                        break;
                    case R.id.allbooks:
                        FragmentTransaction cartTrans=getSupportFragmentManager().beginTransaction();
                        cartTrans.replace(R.id.content,new Cartfragment());
                        cartTrans.commit();
                        break;
                    case R.id.dues:
                        FragmentTransaction dueTrans=getSupportFragmentManager().beginTransaction();
                        dueTrans.replace(R.id.content,new duesfragment());
                        dueTrans.commit();
                        break;
                    case R.id.about:
                        FragmentTransaction userTans=getSupportFragmentManager().beginTransaction();
                        userTans.replace(R.id.content,new Userfragment());
                        userTans.commit();
                        break;
                }

            }
        });

        binding.adminfloatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenttt=new Intent(getApplicationContext(), Adminactivity.class);

               startActivity(intenttt);
            }
        });



        binding.floatlightbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);



                Toast.makeText(MainActivity.this,"Light Mode ON",Toast.LENGTH_SHORT).show();
            }
        });
        binding.floatdarkbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                Toast.makeText(MainActivity.this,"Dark Mode ON",Toast.LENGTH_SHORT).show();
            }
        });



    }
    public void restartApp(){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure you want to exit");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finishAffinity();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}