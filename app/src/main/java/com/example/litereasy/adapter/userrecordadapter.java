package com.example.litereasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.litereasy.R;
import com.example.litereasy.models.artbookmodel;
import com.example.litereasy.models.userrecord;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class userrecordadapter extends RecyclerView.Adapter<userrecordadapter.myviewholder>{
    Context context;
    ArrayList<userrecord> list;

    public userrecordadapter(Context context, ArrayList<userrecord> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.userrecord,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myviewholder holder, int position) {
        userrecord userrecord=list.get(position);
        holder.tvusername.setText(userrecord.getUsername());
        holder.tvuserid.setText(userrecord.getUserid());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView tvusername,tvuserid;
        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvusername=itemView.findViewById(R.id.tvusername);
            tvuserid=itemView.findViewById(R.id.tvuserid);
        }
    }
}
