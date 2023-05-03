package com.example.retaildata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText name_data, date_data, address_data, number_data, repair_data;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_data=findViewById(R.id.name_data);
        date_data=findViewById(R.id.date_data);
        address_data=findViewById(R.id.address_data);
        number_data=findViewById(R.id.number_data);
        repair_data=findViewById(R.id.repair_data);



        submit=findViewById(R.id.submitButton);

        submit.setOnClickListener((View.OnClickListener) this);


    }





    private void addItemToSheet()
    {
        final ProgressDialog loading = ProgressDialog.show(this,"Adding Items","Please Wait");
        final String Name =name_data.getText().toString().trim();
        final String  Number =number_data.getText().toString().trim();
        final String  Date=date_data.getText().toString().trim();
        final String  Address=address_data.getText().toString().trim();
        final String  Repair_Item=repair_data.getText().toString().trim();





        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://script.google.com/macros/s/AKfycbyQzngMztq-6gZJ9VTT3QOqh0sICfmt-Llg5CHngLiW1lmCAh3t70JNVgq8zZPqc0k/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Intent intent = new Intent(getApplicationContext(), Data.class);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            protected Map<String, String> getParams () {
            Map<String, String> params = new HashMap<>();
            params.put("action", "addItem");
            params.put("Name", Name);
            params.put("Phone Number", Number);
            params.put("Date", Date);
            params.put("Address", Address);
            params.put("Repair_Item", Repair_Item);


            return params;
        }
        };





            int SocketTimeOut =10000;

            RetryPolicy retryPolicy = new DefaultRetryPolicy(SocketTimeOut,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            stringRequest.setRetryPolicy(retryPolicy);

                RequestQueue queue= Volley.newRequestQueue(this);
                queue.add(stringRequest);



    }







    public void onClick(View view){

        if(view==submit) {
            addItemToSheet();
        }
    }
}