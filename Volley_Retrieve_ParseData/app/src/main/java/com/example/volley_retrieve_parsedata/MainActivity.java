package com.example.volley_retrieve_parsedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // object that is pre-defined in volley library
        RequestQueue requestQueue;                      // requesting the queue
        requestQueue= Volley.newRequestQueue(this);      // importing volley library

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,       // calling/first method is JSONObjectRequest
                "https://jsonplaceholder.typicode.com/todos/1", null,
                new Response.Listener<JSONObject>() {


// WE ARE USING OBJECT BEACUSE IF WE OPEN THIS URL WE WILL FIND THAT THE DATA STORED IN IT IS IN THE FORM OF OBJECT NOT IN ARRAY

                    
//                    private JSONObject response;



                    @Override
                    public void onResponse(JSONObject response) {                   // Response what will happen if JSON request occurred

                        try {
                            Log.d("VolleyTask", "The Response is: " + response.getString("title"));
                            // this title is an id in jason placeholder api where we are getting the data
                        } catch (JSONException e) {

                            e.printStackTrace();                // it will give the exact line in which exception is raised unlike SOP(e) --> it will only give the error

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {                    // Error Response what will happen if error occurred

                Log.d("VolleyTask", "Something went wrong..");

            }
        });

        requestQueue.add(jsonObjectRequest);                // adding our request to the queue
    }
}