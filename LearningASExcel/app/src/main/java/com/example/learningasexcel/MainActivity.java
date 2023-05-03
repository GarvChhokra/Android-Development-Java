package com.example.learningasexcel;

import androidx.appcompat.app.AppCompatActivity;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final String myTag = "DocsUpload";
    EditText name_data, number_data, address_data, repair_data, amount_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(myTag, "OnCreate()");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                postData();

            }
        });
        t.start();
    }

    public void postData() {

        String fullUrl = "https://docs.google.com/forms/u/0/d/e/1FAIpQLSeCOc_L8OZC-LiA3YSJ2dVSw-xNCTzR16g8fZvkt2-LY6sZgg/formResponse";
        HttpRequest mReq = new HttpRequest();

        name_data=findViewById(R.id.name_data);
        String name = name_data.getText().toString();

        number_data=findViewById(R.id.number_data);
        String number = number_data.getText().toString();

        address_data=findViewById(R.id.address_data);
        String address = address_data.getText().toString();

        repair_data=findViewById(R.id.repair_part);
        String part = repair_data.getText().toString();

        amount_data=findViewById(R.id.amount_data);
        String amount = amount_data.getText().toString();

        String col1 = name;
        String col2 = number;
        String col3= address;
        String col4= part;
        String col5= amount;


        String data = "i1" + URLEncoder.encode(col1) + "&" +
                "i5" + URLEncoder.encode(col2) + "&" + "i9"+ URLEncoder.encode(col3) + "&" + "i13"+ URLEncoder.encode(col4)+ "&" + "i17"+ URLEncoder.encode(col5);


        String response = mReq.sendPost(fullUrl, data);
        Log.i(myTag, response);
    }







    // Link for FORM
        //
        // https://docs.google.com/forms/u/0/d/e/1FAIpQLSeCOc_L8OZC-LiA3YSJ2dVSw-xNCTzR16g8fZvkt2-LY6sZgg/formResponse


        // Name   i1
        // Repair Part i13
        // Number i5
        // Address i9
        // Amount i17
    }
