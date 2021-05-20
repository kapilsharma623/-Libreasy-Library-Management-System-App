package com.example.litereasy;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.litereasy.activities.Adminactivity;


public class smsemail extends Fragment {

    public smsemail() {
        // Required empty public constructor
    }
    ImageView back;
    EditText email,subject,body;
    Button btnsned;
    EditText to, msg;
    Button send;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_smsemail, container, false);
        back=view.findViewById(R.id.backbtn);
        email = view.findViewById(R.id.etTo);
        subject = view.findViewById(R.id.etSubject);
        body  = view.findViewById(R.id.etBody);
        btnsned = view.findViewById(R.id.buttonsend);
        to = view.findViewById(R.id.to);
        msg = view.findViewById(R.id.msg);
        send = view.findViewById(R.id.send);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), Adminactivity.class));
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String number = to.getText().toString();
                    String message = msg.getText().toString();
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(number, null, message, null, null);
                        Toast.makeText(getContext(), "Message sent Successfully", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
                    Toast.makeText(getContext(), "Message sent Successfully", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnsned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().isEmpty() && !subject.getText().toString().isEmpty()
                        && !body.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] {email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT,body.getText().toString());
                    intent.setType("message/rfc822");

                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(),"There is no application that support this action",Toast.LENGTH_LONG).show();

                    }
                }
                else {
                    Toast.makeText(getContext(),"Please Fill all the details",Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }
}