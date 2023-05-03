package com.example.databaseworkingcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.databaseworkingcrud.data.MyDbHandler;
import com.example.databaseworkingcrud.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        List<Contact> contacts = db.getAllContacts();

        // deleting record
        db.deleteContact(43);
        Log.d("Name", "onDelete: Deleted");

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        // Counting
        Log.d("Name", "onCount: Total Number of recorde are: "+ db.getContactsCount());
    }
}