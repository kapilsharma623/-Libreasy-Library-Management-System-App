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
import android.widget.EditText;
import android.widget.Toast;

import com.example.litereasy.activities.duebookkk;
import com.example.litereasy.adapter.duesadapter;
import com.example.litereasy.models.artbookmodel;
import com.example.litereasy.models.duesmodel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class duesfragment extends Fragment {
   Button check;
   EditText id;

    public duesfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_duesfragment, container, false);
        check=view.findViewById(R.id.checkduesbtn);
        id=view.findViewById(R.id.userid);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid=id.getText().toString();
                if(!userid.isEmpty())
                {
                    Intent intent=new Intent(view.getContext(), duebookkk.class);
                    intent.putExtra("useriiid",userid);
                    startActivity(intent);
                }
                else {
                    id.setError("Enter User Id");
                }


            }
        });

        return view;
    }
}