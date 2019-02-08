package com.example.admin.syntechsolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserDetailsActivity extends AppCompatActivity {
    String image,name,phone,email,address,gender;
    TextView tvUDName,tvUDPhone,tvUDEmail,tvUDAddress,tvUDGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        tvUDName=findViewById(R.id.tvUserDeatilsName);
        tvUDPhone=findViewById(R.id.tvUserDeatilsPhone);
        tvUDEmail=findViewById(R.id.tvUserDeatilsEmail);
        tvUDAddress=findViewById(R.id.tvUserDeatilsAddress);
        tvUDGender=findViewById(R.id.tvUserDeatilsGender);
        //image=getIntent().getStringExtra("image");
        name=getIntent().getStringExtra("name");
        email=getIntent().getStringExtra("email");
        phone=getIntent().getStringExtra("phone");
        address=getIntent().getStringExtra("address");
        gender=getIntent().getStringExtra("gender");
        tvUDName.setText(name);
        tvUDPhone.setText(phone);
        tvUDEmail.setText(email);
        tvUDAddress.setText(address);
        tvUDGender.setText(gender);

        tvUDName.setText(name);
        tvUDPhone.setText(phone);
        tvUDEmail.setText(email);
        tvUDAddress.setText(address);
        tvUDGender.setText(gender);
    }
}
