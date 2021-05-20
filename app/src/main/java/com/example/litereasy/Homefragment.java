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
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.litereasy.activities.searchresultactivity;
import com.example.litereasy.adapter.allbooksadapter;
import com.example.litereasy.adapter.artbookadapterrr;
import com.example.litereasy.adapter.newcollectionadapter;
import com.example.litereasy.models.allbooksmodel;
import com.example.litereasy.models.artbookmodel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class Homefragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView recyclerV;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    RecyclerView recyclerView5;


    newcollectionadapter ada;
    artbookadapterrr artbookadapterrr;
    artbookadapterrr techbookadapter;
    artbookadapterrr kidsbookadapter;
    artbookadapterrr exambookadapter;
    artbookadapterrr popularbookadapter;

    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    DatabaseReference databaseReference3;
    DatabaseReference databaseReference4;
    DatabaseReference database;
    DatabaseReference databaseRefer;

    ArrayList<artbookmodel> list;
    ArrayList<artbookmodel> list2;
    ArrayList<artbookmodel> list3;
    ArrayList<artbookmodel> list4;
    ArrayList<artbookmodel> list5;
    ArrayList<artbookmodel> listt;


    EditText searchtxt;
    LinearLayout searchbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);

        searchtxt=view.findViewById(R.id.tvsearchbar);
        searchbtn=view.findViewById(R.id.searchbuttontv);

        recyclerView = (RecyclerView) view.findViewById(R.id.newcollectionrecyclerview);
        database=FirebaseDatabase.getInstance().getReference().child("Allbooks");
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        list5=new ArrayList<>();
        ada = new newcollectionadapter(view.getContext(),list5);
        recyclerView.setAdapter(ada);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshott:snapshot.getChildren())
                {
                    artbookmodel artbookmodelll=dataSnapshott.getValue(artbookmodel.class);
                    list5.add(0,artbookmodelll);

                }
                ada.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        /* popular recycler view below */
        recyclerView5=(RecyclerView) view.findViewById(R.id.popularbookrecycler);
        databaseRefer=FirebaseDatabase.getInstance().getReference().child("popular");
        recyclerView5.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        listt=new ArrayList<>();
        popularbookadapter=new artbookadapterrr(view.getContext(),listt);
        recyclerView5.setAdapter(popularbookadapter);
        databaseRefer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot6:snapshot.getChildren())
                {
                    artbookmodel artbookmo=dataSnapshot6.getValue(artbookmodel.class);
                    listt.add(artbookmo);
                }
                popularbookadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        /* technology recycler view below */
        recyclerView2=(RecyclerView) view.findViewById(R.id.technologybookrecycler);
        databaseReference2=FirebaseDatabase.getInstance().getReference().child("technology");
        recyclerView2.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
        list2=new ArrayList<>();
        techbookadapter=new artbookadapterrr(view.getContext(),list2);
        recyclerView2.setAdapter(techbookadapter);
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot1: snapshot.getChildren())
                {
                    artbookmodel artbookmodel1=dataSnapshot1.getValue(artbookmodel.class);
                    list2.add(artbookmodel1);
                }
                techbookadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });



        /* arts recycler view below */
        recyclerV=(RecyclerView) view.findViewById(R.id.artbookrecycler);
        databaseReference=FirebaseDatabase.getInstance().getReference().child("arts");
        recyclerV.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
        list=new ArrayList<>();
        artbookadapterrr=new artbookadapterrr(view.getContext(),list);
        recyclerV.setAdapter(artbookadapterrr);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    artbookmodel artbookmodel=dataSnapshot.getValue(com.example.litereasy.models.artbookmodel.class);
                    list.add(artbookmodel);
                }
                artbookadapterrr.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        /* kids recycler view below */
        recyclerView3=(RecyclerView) view.findViewById(R.id.kidsrecyclerview);
        databaseReference3=FirebaseDatabase.getInstance().getReference().child("kids");
        recyclerView3.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
        list3=new ArrayList<>();
        kidsbookadapter=new artbookadapterrr(view.getContext(),list3);
        recyclerView3.setAdapter(kidsbookadapter);
        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
               for (DataSnapshot dataSnapshot3:snapshot.getChildren())
               {
                   artbookmodel artbookmodell=dataSnapshot3.getValue(com.example.litereasy.models.artbookmodel.class);
                   list3.add(artbookmodell);
               }
                kidsbookadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        /*exam */
        recyclerView4=(RecyclerView) view.findViewById(R.id.exambookrecycler);
        databaseReference4=FirebaseDatabase.getInstance().getReference().child("exams");
        recyclerView4.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
        list4=new ArrayList<>();
        exambookadapter=new artbookadapterrr(view.getContext(),list4);
        recyclerView4.setAdapter(exambookadapter);
        databaseReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot4:snapshot.getChildren())
                {
                    artbookmodel artbookmodel4=dataSnapshot4.getValue(artbookmodel.class);
                    list4.add(artbookmodel4);
                }
                exambookadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=searchtxt.getText().toString();
                if (!text.isEmpty())
                {
                    Intent intent=new Intent(view.getContext(), searchresultactivity.class);
                    intent.putExtra("searchresult",text);
                    startActivity(intent);
                }
                else {
                    searchtxt.setError("Enter Book Name");
                }

            }
        });

        return view;
    }

}