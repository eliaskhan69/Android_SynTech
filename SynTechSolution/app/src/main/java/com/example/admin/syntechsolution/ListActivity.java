package com.example.admin.syntechsolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView listViewUsers;
    ArrayList<User> arrayListUser;
    CustomAdapter arrayAdapterUser;
    User user;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String id,image,name,email,address,phone,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        arrayListUser=new ArrayList<User>();
        listViewUsers=findViewById(R.id.listViewUsers);
        arrayAdapterUser=new CustomAdapter(this,R.layout.list_item_layout);
        listViewUsers.setAdapter(arrayAdapterUser);

        json_string=getIntent().getStringExtra("json_string");
         try {
            jsonObject=new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("Data");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1= (JSONObject) jsonArray.get(i);
                id=jsonObject1.getString("ID");
                image=jsonObject1.getString("ProfilePic");
                name=jsonObject1.getString("Name");
                email=jsonObject1.getString("Email");
                address=jsonObject1.getString("Address");
                phone=jsonObject1.getString("Phone");
                gender=jsonObject1.getString("Gender");
                user=new User(name,email,phone,address,gender);
                arrayAdapterUser.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listViewUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(ListActivity.this,"HELLO", Toast.LENGTH_SHORT).show();
                //int image=arrayListUser.get(i).getImage();
                String name=arrayListUser.get(i).getName();
                String email=arrayListUser.get(i).getEmail();
                String phone=arrayListUser.get(i).getPhone();
                String gender=arrayListUser.get(i).getGender();
                String address=arrayListUser.get(i).getAddress();
                startActivity(new Intent(ListActivity.this,UserDetailsActivity.class)
                .putExtra("image",image)
                .putExtra("name",name)
                .putExtra("email",email)
                .putExtra("phone",phone)
                .putExtra("address",address)
                .putExtra("gender",gender));
            }
        });
    }

}
