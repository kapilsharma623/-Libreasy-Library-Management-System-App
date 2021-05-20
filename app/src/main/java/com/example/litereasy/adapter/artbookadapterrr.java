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
import com.example.litereasy.bookdetailsonclickfragment;
import com.example.litereasy.models.artbookmodel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class artbookadapterrr extends RecyclerView.Adapter<artbookadapterrr.MyViewHolder> {
    Context context;
    ArrayList<artbookmodel> list;

    public artbookadapterrr(Context context, ArrayList<artbookmodel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.booktypelayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
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

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout boxlayout;
        ImageView bookimage;
        TextView bookname,booksubject,bookauthor,bookquantity;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            bookname=itemView.findViewById(R.id.arttvbooknamee);
            booksubject=itemView.findViewById(R.id.arttvbooksubjectt);
            bookauthor=itemView.findViewById(R.id.arttvbookauthorr);
            bookquantity=itemView.findViewById(R.id.arttvbookquantityy);
            bookimage=itemView.findViewById(R.id.arttbookimageview);
            boxlayout=itemView.findViewById(R.id.arttbookbox);
        }
    }
}
