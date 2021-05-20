package com.example.litereasy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.litereasy.databinding.FragmentArtsbookfragmentBinding;
import com.example.litereasy.databinding.FragmentBookdetailsonclickfragmentBinding;

public class artsbookfragment extends Fragment {
    FragmentArtsbookfragmentBinding binding;
    String bookid,bookimage,booknamee,bookauthorr,booksubjectt,bookquantityy,bookdescriptionn;
    public artsbookfragment() {
        // Required empty public constructor
    }
    public artsbookfragment(String bookid,String bookimage,String booknamee,String bookauthorr,String booksubjectt,String bookquantityy,String bookdescriptionn) {
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
        binding = FragmentArtsbookfragmentBinding.inflate(getLayoutInflater());

        binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.homeframelayout, new Homefragment()).addToBackStack(null).commit();
            }
        });
        binding.artsbooknameid.setText(booknamee);
        binding.artsbookauthoridd.setText(bookauthorr);
        binding.artsbooksubjectidd.setText(booksubjectt);
        binding.artsbookquantityidd.setText(bookquantityy);
        binding.artsbookdescriptionidd.setText(bookdescriptionn);
        binding.artsbooknameidd.setText(booknamee);
        binding.artsbookidd.setText(bookid);
        Glide.with(getContext()).load(bookimage).into(binding.artsbookimagesource);

        return binding.getRoot();
    }
    public void onBackpressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentartsbookdetail, new Homefragment()).addToBackStack(null).commit();
    }
}