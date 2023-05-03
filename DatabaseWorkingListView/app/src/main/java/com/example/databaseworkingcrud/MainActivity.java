package com.example.databaseworkingcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.databaseworkingcrud.data.MyDbHandler;
import com.example.databaseworkingcrud.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Intent obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        MyDbHandler db = new MyDbHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Updating Record
        db.updateContact(new Contact(2, "Garv", "9027109803"));
        Log.d("Name", "onUpdate; Record Updated");

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");


        listView=findViewById(R.id.listView);
        ArrayList<String> arrayList= new ArrayList<>();


        List<Contact> contacts = db.getAllContacts();

        // deleting record
        db.deleteContact(43);
        Log.d("Name", "onDelete: Deleted");

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);

            arrayList.add(cn.getName()+"("+cn.getPhoneNumber()+")");
        }

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact= new Contact();

                Toast.makeText(MainActivity.this, "Name: "+contact.getName()+ "Phone Number: "+contact.getPhoneNumber(), Toast.LENGTH_SHORT).show();



//                obj=new Intent(this, NewPage.class);
//
//                startActivity(obj);

            }
        });


        // Counting
        Log.d("Name", "onCount: Total Number of records are: "+ db.getContactsCount());
    }
}