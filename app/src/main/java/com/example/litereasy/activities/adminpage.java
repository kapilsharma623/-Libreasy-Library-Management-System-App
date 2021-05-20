package com.example.litereasy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.litereasy.R;
import com.example.litereasy.addbooksfragment;
import com.example.litereasy.addusersfragment;
import com.example.litereasy.availablebookfragment;
import com.example.litereasy.databinding.ActivityAdminpageBinding;
import com.example.litereasy.existinguserfragment;
import com.example.litereasy.smsemail;
import com.example.litereasy.soldbookfragment;
import com.fxn.OnBubbleClickListener;

public class adminpage extends AppCompatActivity {
ActivityAdminpageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAdminpageBinding.inflate(getLayoutInflater());
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            setTheme(R.style.Theme_Dark);
        }
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        FragmentTransaction availTans=getSupportFragmentManager().beginTransaction();
        availTans.replace(R.id.admincontent,new availablebookfragment());
        availTans.commit();

        binding.bottomnavigation.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {
                switch(i)
                {
                    case R.id.availablebooks:
                        FragmentTransaction availTans=getSupportFragmentManager().beginTransaction();
                        availTans.replace(R.id.admincontent,new availablebookfragment());
                        availTans.commit();
                        break;
                    case R.id.existinguser:
                        FragmentTransaction exisTans=getSupportFragmentManager().beginTransaction();
                        exisTans.replace(R.id.admincontent,new existinguserfragment());
                        exisTans.commit();
                        break;
                    case R.id.addusers:
                        FragmentTransaction adduserTrans=getSupportFragmentManager().beginTransaction();
                        adduserTrans.replace(R.id.admincontent,new addusersfragment());
                        adduserTrans.commit();
                        break;
                    case R.id.addbooks:
                        FragmentTransaction addbookTrans=getSupportFragmentManager().beginTransaction();
                        addbookTrans.replace(R.id.admincontent,new addbooksfragment());
                        addbookTrans.commit();
                        break;
                    case R.id.soldbooks:
                        FragmentTransaction soldTrans=getSupportFragmentManager().beginTransaction();
                        soldTrans.replace(R.id.admincontent,new soldbookfragment());
                        soldTrans.commit();
                        break;
                    case R.id.sms:
                        FragmentTransaction smsTrans=getSupportFragmentManager().beginTransaction();
                        smsTrans.replace(R.id.admincontent,new smsemail());
                        smsTrans.commit();
                        break;
                }

            }
        });
    }
}