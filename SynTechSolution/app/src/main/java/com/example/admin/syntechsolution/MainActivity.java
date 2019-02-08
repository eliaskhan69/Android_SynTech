package com.example.admin.syntechsolution;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String json_string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FetchData process=new FetchData();
        process.execute();
    }


    public void showJson(View view) {
        Toast.makeText(this, json_string, Toast.LENGTH_SHORT).show();
    }

    public void showList(View view) {
        startActivity(new Intent(MainActivity.this,ListActivity.class)
        .putExtra("json_string",json_string));
    }

    public void registration(View view) {
        startActivity(new Intent(MainActivity.this,Registration.class));
    }

    public void ShowRegisterData(View view) {
        startActivity(new Intent(MainActivity.this,DisplayRegistratonActivity.class));
    }

    class FetchData extends AsyncTask<Void, Void, String> {
        String JSON_STRING;
        String json_url;

        @Override
        protected void onPreExecute() {
            json_url="http://syntecinternapi.azurewebsites.net/api/user/getusers";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                //URL url=new URL("https://api.myjson.com/bins/1frg2g");
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while ((JSON_STRING=bufferedReader.readLine())!=null){
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            json_string=result;
        }
    }
}