package com.example.databaseworkingcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.databaseworkingcrud.model.Contact;

public class NewPage extends AppCompatActivity {
    TextView textView;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);
        Contact contact=new Contact();
        Intent obj = getIntent();

        textView.findViewById(R.id.textView3);
        textView.setText(contact.getName()+ "     " + contact.getPhoneNumber());

    }
}