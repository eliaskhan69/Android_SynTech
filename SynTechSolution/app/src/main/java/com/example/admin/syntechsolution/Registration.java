package com.example.admin.syntechsolution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
    EditText etName,etPhone,etEmail,etAddress,etGender;
    RequestQueue queue;
    String POST_URL = "http://syntecinternapi.azurewebsites.net/api/user/CreateNew";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etName=findViewById(R.id.etName);
        etPhone=findViewById(R.id.etPhone);
        etEmail=findViewById(R.id.etEmail);
        etAddress=findViewById(R.id.etAddress);
        etGender=findViewById(R.id.etGender);
        queue= Volley.newRequestQueue(getApplicationContext());
    }

    public void Submit(View view) {

        //Toast.makeText(Registration.this,etName.getText().toString(),Toast.LENGTH_LONG).show();

        StringRequest postRequest = new StringRequest(Request.Method.POST, POST_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        //RequestQueue.getCache().clear();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();

                params.put("name",etName.getText().toString());
                params.put("phone",etPhone.getText().toString());
                params.put("email",etEmail.getText().toString());
                params.put("address",etAddress.getText().toString());
                params.put("gender",etGender.getText().toString());
                return params;
            }
        };
        queue.add(postRequest);
    }

    public void showdata(View view) {
    }
}
