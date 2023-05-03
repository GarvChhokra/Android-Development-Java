package com.example.databaseinlistview.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.databaseinlistview.model.Contact;
import com.example.databaseinlistview.parameters.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context,Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE "+ Params.TABLE_NAME+"(" + Params.KEY_ID+"INTEGER PRIMARY KEY,"+Params.KEY_Name+"TEXT,"+Params.KEY_phoneNumber+"TEXT)";
        Log.d("GarvChhokra", "onCreate: CREATED OUR TABLE");

        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addData(Contact contact){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(Params.KEY_Name,contact.getId());
        contentValues.put(Params.KEY_Name,contact.getName());
        contentValues.put(Params.KEY_phoneNumber,contact.getPhoneNumber());

        db.insert(Params.TABLE_NAME,null,contentValues);
        Log.d("GarvChhokra", "addData: Data Added:");
        db.close();


    }


    //
    public List<Contact> getData(){
        List<Contact> contactList= new ArrayList<>();

        SQLiteDatabase db =this.getReadableDatabase();

        String select="SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(select,null);

        Log.d("GarvChhokra", "gatData: Getting Data Function Ready");

        if(cursor.moveToFirst()){
            do {
                Contact contact=new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                contactList.add(contact);
            }while (cursor.moveToNext());
        }


        return contactList;
    }





}
