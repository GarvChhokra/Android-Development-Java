package com.example.background_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // Now to do a ascynchronous task in background we extends this library
    public class BG extends AsyncTask<String,Void,String>{

        // What will happen before
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("bgTask", "onPreExecute: ran");

        }


        // what will happen after
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("bgTask", "onPostExecute: ran");

            // printing what we get the data from the ccs website
            Log.d("bgTask",s);
        }


        // what will happen while we are doing task
        @Override
        protected String doInBackground(String... urls) {
            Log.d("bgTask", "doInBackground: ran");

            // getting data from another website
            String result = "";
            URL url;
            HttpURLConnection conn;


            try{
            url = new URL(urls[0]);
            conn = (HttpURLConnection) url.openConnection();
            InputStream in = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();

            while (data != -1) {
                char current = (char) data;
                result += current;
                data = reader.read();

            }
        }


            catch (Exception e){
                e.printStackTrace();
                return "Something went wrong";
            }




                // this return value will go to our post method to print the data og the website
            return result;



        }
    }

    public void toast(View view){
        Toast.makeText(this, "This ia my Toast", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // now creating object for our BG class which we have created
        BG mytask=new BG();
        mytask.execute("https://www.codewithharry.com/");



    }

}