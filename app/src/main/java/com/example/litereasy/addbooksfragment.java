package com.example.litereasy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.litereasy.activities.Adminactivity;
import com.example.litereasy.databinding.FragmentAddbooksfragmentBinding;
import com.example.litereasy.models.addnewbookmodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;


public class addbooksfragment extends Fragment {

    FirebaseStorage storage;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference refer;
    DatabaseReference refer2;
    DatabaseReference refer3;
    StorageReference storageReference;
    DatabaseReference r3;
    StorageReference str;
    FragmentAddbooksfragmentBinding binding;
    Uri sfile,storageimagee;
    private String imageurll;

            @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            binding= FragmentAddbooksfragmentBinding.inflate(getLayoutInflater());
            storage=FirebaseStorage.getInstance();
            storageReference=storage.getReference();
            refer2=FirebaseDatabase.getInstance().getReference().child("Allbooks").push();
            binding.backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Adminactivity.class));
            }
            });
            binding.bookimagee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_GET_CONTENT);
                            intent.setType("image/*");
                            startActivityForResult(intent, 33);

                }
            });
            refer=FirebaseDatabase.getInstance().getReference().child("Allbooks");
            binding.tvsubmitbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    insertstudentdata();
                }
            });

        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.getData()!=null)
        {
            sfile=data.getData();
            binding.bookimagee.setImageURI(sfile);
            uploadbookimage();

        }
    }
    private void insertstudentdata()
    {
        String bookname=binding.tvnewbookname.getText().toString();
        String subject=binding.tvbooksubject.getText().toString();
        String author=binding.tvbookauthor.getText().toString();
        String date=binding.tvnewbookdate.getText().toString();
        String quantity=binding.tvquantity.getText().toString();
        String description=binding.tvbookdescription.getText().toString();
        String bookid=refer2.getKey();
        String imgurlsource=imageurll;
        refer3=FirebaseDatabase.getInstance().getReference().child(subject);
        addnewbookmodel book=new addnewbookmodel(bookid,bookname,subject,author,date,quantity,description,imgurlsource);
        refer.child(bookid).setValue(book);
        HashMap<String,Object> dataaa=new HashMap<>();
        dataaa.put("bookimage",imageurll);
        refer3.child(bookid).setValue(dataaa).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getContext(),"Uploaded in Database",Toast.LENGTH_SHORT).show();
            }
        });
        refer3.child(bookid).setValue(book);

        Toast.makeText(getContext(),"Data Uploaded",Toast.LENGTH_SHORT).show();

    }
    private void uploadbookimage()
    {
        final String randomkey= UUID.randomUUID().toString();
        StorageReference refstorage=storageReference.child("Bookimages/"+randomkey);
        refstorage.putFile(sfile).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<UploadTask.TaskSnapshot> task) {
                task.getResult().getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        HashMap<String,Object> dataa=new HashMap<>();
                        imageurll=uri.toString();
                        dataa.put("bookimage",imageurll);
                        refer2.setValue(dataa).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                              Toast.makeText(getContext(),"Uploaded in Database",Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
            }
        });

    }
}