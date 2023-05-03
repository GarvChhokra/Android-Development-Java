package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.myListView);

        ArrayList<String> mynotes = new ArrayList<>();
        mynotes.add("Android Development");
        mynotes.add("Javascript");
        mynotes.add("C");
        mynotes.add("Web Development");

        // to use java array in android studio we have to use AndroidAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mynotes);
        myListView.setAdapter(arrayAdapter);


        // this we are writing so that a particular action called on clicking our text


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // only we have to write myListView.setOnItemClickListener(new AdapterView.O and click
            // enter whole code will import by its own
            
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();   this is prebuilt
                Toast.makeText(MainActivity.this, "Topic "+(position+1)+": "
                        +((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
//                ((TextView)view).getText().toString()   ==> this is used to get our text and will show in our toast


            }
        }
        );

    }
}