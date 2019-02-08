package com.example.admin.syntechsolution;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DisplayRegistratonActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    RequestQueue queue;
    String GET_URL = "http://syntecinternapi.azurewebsites.net/api/user/GetUserBy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_registraton);
        listView=findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        queue = Volley.newRequestQueue(getApplicationContext());
        adapter = new ArrayAdapter<>(DisplayRegistratonActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        if(isNetworkAvailable()) {
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, GET_URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    //txtDisplay.setText("Response = "+response.toString());
                    int length = response.length();
                    for (int i = 0; i < length; i++) {
                        try {
                            String name = response.getJSONObject(i).getString("name");
                            String phone = response.getJSONObject(i).getString("phone");
                            arrayList.add(name + "\n" + phone);
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error", error.getCause().toString());
                }
            });
            queue.add(jsonArrayRequest);
        }else{
            Toast.makeText(DisplayRegistratonActivity.this, "Connect Your Internet Please", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
