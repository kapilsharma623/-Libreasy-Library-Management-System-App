package com.example.litereasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.litereasy.R;
import com.example.litereasy.artsbookfragment;
import com.example.litereasy.models.artbookmodel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class newcollectionadapter extends RecyclerView.Adapter<newcollectionadapter.myviewholder>{
    Context context;
    ArrayList<artbookmodel> list;

    public newcollectionadapter(Context context, ArrayList<artbookmodel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.newcollectionlayout,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myviewholder holder, int position) {
        artbookmodel artbookmodel=list.get(position);
        holder.bookname.setText(artbookmodel.getBookname());
        holder.bookauthor.setText(artbookmodel.getAuthor());
        holder.booksubject.setText(artbookmodel.getSubject());
        holder.bookquantity.setText(artbookmodel.getQuantity());
        Glide.with(holder.bookimage.getContext()).load(artbookmodel.getBookimage()).into(holder.bookimage);
        holder.boxlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.homeframelayout,
                        new artsbookfragment(artbookmodel.getBookid(),artbookmodel.getBookimage(),artbookmodel.getBookname(),artbookmodel.getAuthor(),artbookmodel.getSubject(),
                                artbookmodel.getQuantity(),artbookmodel.getDescription()))
                        .addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        LinearLayout boxlayout;
        ImageView bookimage;
        TextView bookname,booksubject,bookauthor,bookquantity;
        public myviewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            bookname=itemView.findViewById(R.id.tvbooknamee);
            booksubject=itemView.findViewById(R.id.tvbooksubjectt);
            bookauthor=itemView.findViewById(R.id.tvbookauthorr);
            bookquantity=itemView.findViewById(R.id.tvbookquantityy);
            bookimage=itemView.findViewById(R.id.bookimageview);
            boxlayout=itemView.findViewById(R.id.bookbox);
        }
    }
}
