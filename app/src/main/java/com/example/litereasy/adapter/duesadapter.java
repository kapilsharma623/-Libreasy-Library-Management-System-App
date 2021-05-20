package com.example.litereasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.litereasy.R;
import com.example.litereasy.models.artbookmodel;
import com.example.litereasy.models.duesmodel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class duesadapter extends RecyclerView.Adapter<duesadapter.myviewholder>{
    Context context;
    ArrayList<duesmodel> list;
    DatabaseReference databaseReference;
    artbookmodel artbookmodel;

    public duesadapter(Context context, ArrayList<duesmodel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.duebooklayout,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myviewholder holder, int position) {
        duesmodel duesmodel=list.get(position);
        String naame=duesmodel.getBookname();
        String bookidd=duesmodel.getBookid();
        String date=duesmodel.getDate();
        String duedate=duesmodel.getDuedate();
        holder.bookname.setText(naame);
        holder.bookid.setText(bookidd);
        holder.broughtdate.setText(date);
        holder.duedate.setText(duedate);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView bookimage;
        TextView bookname,bookid,broughtdate,duedate;
        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            bookimage=itemView.findViewById(R.id.bookimage);
            bookname=itemView.findViewById(R.id.bookname);
            bookid=itemView.findViewById(R.id.bookid);
            broughtdate=itemView.findViewById(R.id.broughtdate);
            duedate=itemView.findViewById(R.id.duedate);
        }
    }
}
