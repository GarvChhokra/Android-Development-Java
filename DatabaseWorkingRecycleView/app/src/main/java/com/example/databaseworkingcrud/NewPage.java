package com.example.databaseworkingcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_page);

        Intent intent=getIntent();
        String name = intent.getStringExtra("R_name");
        String phone = intent.getStringExtra("R_phoneNumber");
        TextView textView=findViewById(R.id.Name);
        textView.setText(name);
        TextView textView1=findViewById(R.id.PhoneNumber);
        textView1.setText(phone);
    }
}