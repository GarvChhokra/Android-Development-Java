package com.example.volleycontinue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos", null,
                new Response.Listener<JSONArray>() {

            // WE ARE USING ARRAY BECAUSE IF WE OPEN THIS URL WE WILL FIND THAT THE DATA IS STORED IN THE ARRAY BUT NOT IN OBJECT THAT'S WHY WE USED ARRAY AND WE NEED OBJECT TO
                    // SHOW OR PRINT THAT'S WHY WE LATER USED OBJECT TO PRINT

                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            for (int i=0;i<response.length();i++) {
                                // here we are using Json OBJECT because we cant add into Json ARRAY  because to call the data from lets say id title we need object to get it
                                // that`s why we have written obj.getString that s why we have created Json OBJECT
                                JSONObject obj=response.getJSONObject(i);
                                Log.d("Volley_Continue", "The respone is: " +obj.getString("title") +" and the user id is: "+ obj.getInt("userId"));
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);


        
    }
}