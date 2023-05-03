
package com.example.usingdatabase;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.usingdatabase.data.MyDbHandler;
import com.example.usingdatabase.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Creating object of our MyDBHandler class
        MyDbHandler db=new MyDbHandler(MainActivity.this);

        // Adding contact to db
        Contact data1 =new Contact();
        data1.setName("Garv");
        data1.setPhoneNumber("9027109803");
        db.addContact(data1);

        Log.d("sqlYEAH", "data1 added successfully");

        //
        Contact data2 =new Contact();
        data2.setName("Varun");
        data2.setPhoneNumber("8218240102");
        db.addContact(data2);

        Log.d("sqlYEAH", "data2 added successfully");


        // Updating record name and phone number of our data2

        // id id required to update our data
        data2.setId(2);
        data2.setName("Varuun");
        data2.setPhoneNumber("80773355735");
        int affectedRows = db.updateContact(data2);
        Log.d("sqlYEAH", "Affected and Updated data2"+affectedRows);


        //
        Contact data3 =new Contact();
        data3.setName("Mom");
        data3.setPhoneNumber("9719931025");
        db.addContact(data3);

        Log.d("sqlYEAH", "data3 added successfully");


        Log.d("sqlYEAH", "data 1 data2 data3 successfully added ");




        //
        List<Contact> contactList=db.readContact();
        Log.d("sqlYEAH", "Showing our entered data:");



        // DELETING we are deleting data having id 1
        db.deleteContact(1);



        Log.d("sqlYEAH", "Our Record Deleted Successfully");


        for(Contact contact: contactList){



            Log.d("sqlYEAH", "About to Show our entered data:");



            Log.d("sqlYEAH", "Id: " +contact.getId() + "\n" +
                                        "Name: "+ contact.getName() +"\n"+
                                        "Phone Number: "+ contact.getPhoneNumber() +"\n");
        }



        // Counting Records
        Log.d("sqlYEAH", "Total Number of Record found: " +db.countRecords());




//        List<Contact> allContacts = db.readContact();
//        for(Contact contact: allContacts) {
//            Log.d("sqlYEAH", "\nId: " + contact.getId() + "\n" +
//                    "Name: " + contact.getName() + "\n" +
//                    "Phone Number: " + contact.getPhoneNumber() + "\n");
//        }
    }
}