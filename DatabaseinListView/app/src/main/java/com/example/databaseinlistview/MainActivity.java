package com.example.databaseinlistview;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.databaseinlistview.data.MyDbHandler;
import com.example.databaseinlistview.model.Contact;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        MyDbHandler db=new MyDbHandler(MainActivity.this);
        Log.d("GarvChhokra  ", "onCreate: Our table Created");

        // Adding data
        Contact data1=new Contact();
        data1.setName("Garv");
        data1.setPhoneNumber("9027109803");
        db.addData(data1);

        Contact data2=new Contact();
        data2.setName("Varun");
        data2.setPhoneNumber("8218240102");
        db.addData(data2);

        Log.d("GarvChhokra", "onCreate: Data Added Successfully");


        // Showing data in ListView
        listView=findViewById(R.id.listView);

        ArrayList<String> arraycontacts= new ArrayList<>();

        //
        List<Contact> contactList=db.getData();

        Log.d("GarvChhokra", "onCreate: Data Showing logd is left to write");
        for (Contact contact: contactList){

            Log.d("GarvChhokra", "onCreate: Data is about to Display...");
            Log.d("GarvChhokra", "Id: "+contact.getId() + "   Name: "+ contact.getName()+
                    "     Phone Number: "+contact.getPhoneNumber());

            arraycontacts.add(contact.getName()+"("+contact.getPhoneNumber()+")");
        }


        // Array Adapter
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arraycontacts);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = new Contact();
                Toast.makeText(MainActivity.this, "Name:"+contact.getName()+" Phone Number:"+ contact.getPhoneNumber(), Toast.LENGTH_SHORT).show();
            }
        });





    }
}