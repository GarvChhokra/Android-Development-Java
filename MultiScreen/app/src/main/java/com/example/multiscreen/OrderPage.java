package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);


        Intent obj = getIntent();
        String message = "Order for " +obj.getStringExtra(MainActivity.msg)+ " has been placed successfully";     /* here we are creating a string named message and then using a predefined function (getStringExtra())
                                                                   and we are passing our main java file name with the msg named string which we have define in our main file
                                                                   //  (( obj.putExtra(msg, message);   ))    to pass our data to this activity
                                                                    **/
        TextView ob = findViewById(R.id.orderdata);
        ob.setText(message);



    }
}