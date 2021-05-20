package com.example.litereasy;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.litereasy.databinding.FragmentBookdetailsonclickfragmentBinding;


public class bookdetailsonclickfragment extends Fragment {

    FragmentBookdetailsonclickfragmentBinding binding;
    String bookid,bookimage,booknamee,bookauthorr,booksubjectt,bookquantityy,bookdescriptionn;
    public bookdetailsonclickfragment() {

    }

    public bookdetailsonclickfragment(String bookid,String bookimage,String booknamee,String bookauthorr,String booksubjectt,String bookquantityy,String bookdescriptionn) {
     this.bookid=bookid;
     this.bookimage=bookimage;
     this.booknamee=booknamee;
     this.bookauthorr=bookauthorr;
     this.booksubjectt=booksubjectt;
     this.bookquantityy=bookquantityy;
     this.bookdescriptionn=bookdescriptionn;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBookdetailsonclickfragmentBinding.inflate(getLayoutInflater());

        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.cartframelayout, new Cartfragment()).addToBackStack(null).commit();
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


        return binding.getRoot();
    }
    public void onBackpressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.cartframelayout, new Cartfragment()).addToBackStack(null).commit();
    }

}