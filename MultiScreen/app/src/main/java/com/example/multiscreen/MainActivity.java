package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String msg = "com.example.multiscreen.order";      // public static final is written before the string so that it can't be changed
    public void placeOrder(View view){
        Intent obj = new Intent(this, OrderPage.class);
        EditText ob1 = findViewById(R.id.item1);
        EditText ob2 = findViewById(R.id.item2);
        EditText ob3 = findViewById(R.id.item3);

        String message;
        message = ob1.getText().toString() + ", " +ob2.getText().toString()+" & " +ob3.getText().toString();

        obj.putExtra(msg, message);  // we can pass key value pairs from this line of code
        // from this we are passing the message string data to the msg that is mentioned above as a string


        startActivity(obj);  // from this second activity named OrderActivity will run

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}