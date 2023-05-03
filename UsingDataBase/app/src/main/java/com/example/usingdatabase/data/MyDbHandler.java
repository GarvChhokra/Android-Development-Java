package com.example.usingdatabase.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.usingdatabase.model.Contact;
import com.example.usingdatabase.parameters.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {


    // Here we will add our database and perform actions
    // Constructor
    public MyDbHandler(Context context){
        // Context? = Android needs that where you have invoked this That is the context of this application
        super(context, Params.DB_NAME,null, Params.DB_VERSION);
    }
    // cmd+n will help you to insert easily -> Override methods
    // ON CREATING OUR DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Issuing our Sql query to create table and its row names
        String create="CREATE TABLE "+Params.TABLE_NAME+
                "("+Params.KEY_ID + "INTEGER PRIMARY KEY,"
                + Params.KEY_Name +"TEXT,"
                + Params.KEY_contact+"TEXT"+")";

        Log.d("sqlYEAH", create);


        // pre-defined to run your SQL
        db.execSQL(create);

    }
    // WHAT WILL HAPPEN IF WE UPDATE OUR DATA
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


// created a function named addContact that passes argument Contact class which we have created as java class
    public void addContact(Contact contact){

        // used to write in our database
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(Params.KEY_Name, contact.getName());
        contentValues.put(Params.KEY_contact, contact.getPhoneNumber());

        db.insert(Params.TABLE_NAME,null,contentValues);
        Log.d("sqlYEAH", "Successfully Inserted");
        db.close();


    }

    public List<Contact> readContact(){
        List<Contact> contactList = new ArrayList<>();

        //
        SQLiteDatabase db=this.getReadableDatabase();

        //
        String select ="SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        // Loop through now
        if (cursor.moveToFirst()){
            do {
                Contact contact=new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                // we are writing Integer.parseInt  because of changing the type of our ID to int because it stores integer
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                //
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        return contactList;

    }


    // Updating Contacts
    public int updateContact(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put(Params.KEY_Name,contact.getName());
        contentValues.put(Params.KEY_contact,contact.getPhoneNumber());


        // Updating Data
        return db.update(Params.TABLE_NAME, contentValues, Params.KEY_ID+"=?",
                new String[]{String.valueOf(contact.getId())});
        // Params.KEY_ID+"=?"+   ===> meaning my id will be equal to(=?) this String


    }

    // Deleting Contacts  using its id we can also delete them by using their name or whatever
    public void deleteContact(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        //
        db.delete(Params.TABLE_NAME, Params.KEY_ID+"=?", new String[]{String.valueOf(id)});

        db.close();
    }



    // COUNT FUNCTION
    public int countRecords(){
        String count="SELECT * FROM " + Params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(count, null);
        return cursor.getCount();
    }
}



