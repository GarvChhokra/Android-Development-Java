package com.example.sharedpreferences_savingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=editText.getText().toString();
                SharedPreferences sharedPreferences=getSharedPreferences("demo", MODE_PRIVATE);
                // Mode Private means only this application can read/use this shared preference
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("str",msg);
                editor.apply();

                textView.setText(msg);
            }
        });


        // getting data from sharedPreference
        SharedPreferences data=getSharedPreferences("demo", MODE_PRIVATE);
        String value=data.getString("str","Write you message and it will show up here");
        textView.setText(value);
    }
}