package com.example.litereasy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.litereasy.R;
import com.example.litereasy.bookdetailsonclickfragment;
import com.example.litereasy.models.allbooksmodel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class allbooksadapter extends FirebaseRecyclerAdapter<com.example.litereasy.models.allbooksmodel,allbooksadapter.myviewholder> {

    public allbooksadapter(@NonNull FirebaseRecyclerOptions<allbooksmodel> options) {
        super(options);
    }

    allbooksmodel allbooksmodel;
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull allbooksmodel model) {
        holder.tvbooknamee.setText(model.getBookname());
        holder.tvbooksubjectt.setText(model.getSubject());
        holder.tvbookauthorr.setText(model.getAuthor());
        holder.tvbookquantityy.setText(model.getQuantity());
        String bookid= model.getBookid();
        DatabaseReference reference;
        reference= FirebaseDatabase.getInstance().getReference().child("Allbooks").child(bookid);
        reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
            allbooksmodel=snapshot.getValue(allbooksmodel.class);
            Glide.with(holder.bookimageview.getContext()).load(allbooksmodel.getBookimage()).into(holder.bookimageview);
        }

        @Override
        public void onCancelled(@NonNull @NotNull DatabaseError error) {

        }
    });
       holder.bookbox.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AppCompatActivity activity=(AppCompatActivity)view.getContext();
               activity.getSupportFragmentManager().beginTransaction().replace(R.id.cartframelayout,
                       new bookdetailsonclickfragment(model.getBookid(),model.getBookimage(),model.getBookname(),model.getAuthor(),model.getSubject(),
                               model.getQuantity(),model.getDescription()))
                       .addToBackStack(null).commit();
           }
       });
    }

    @NonNull
    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.newcollectionlayout,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView bookimageview;
        TextView tvbooknamee,tvbooksubjectt,tvbookauthorr,tvbookquantityy;
        LinearLayout bookbox;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            bookimageview=itemView.findViewById(R.id.bookimageview);
            tvbooknamee=itemView.findViewById(R.id.tvbooknamee);
            tvbooksubjectt=itemView.findViewById(R.id.tvbooksubjectt);
            tvbookauthorr=itemView.findViewById(R.id.tvbookauthorr);
            tvbookquantityy=itemView.findViewById(R.id.tvbookquantityy);
            bookbox=itemView.findViewById(R.id.bookbox);
        }
    }
}
