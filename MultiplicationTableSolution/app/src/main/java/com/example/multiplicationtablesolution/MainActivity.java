package com.example.multiplicationtablesolution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List view define
        listView=findViewById(R.id.listView);


        // Seek-bar define
        SeekBar seekBar = findViewById(R.id.seekBar);
        // giving seek-bar to max 20
        seekBar.setMax(20);


        // calling on change listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Toast.makeText(MainActivity.this, "Multiplication Table: "+ progress, Toast.LENGTH_SHORT).show();

                // calling populate function and passing progress as variable
                populate(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public  void populate(int table){
        // populating List View

        ArrayList<String> mulTable=new ArrayList<>();
        for(int i=1;i<=10;i++) {

            // Table Layout
            mulTable.add(table+" X "+ i +" = "+table*i);
        }


        // connecting listview to an array to set text
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mulTable);
        listView.setAdapter(arrayAdapter);

    }

}