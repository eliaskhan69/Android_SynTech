package com.example.admin.syntechsolution;

import java.util.ArrayList;

/**
 * Created by admin on 2/8/2019.
 */

public class User {
    private int image;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;

    public User(int image, String name, String email, String phone, String address, String gender) {
        this.image = image;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public User(String name, String email, String phone, String address, String gender) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<User> getAllUser(){
        ArrayList<User> users=new ArrayList<>();
        users.add(new User("ELia","elias@gmail.com","01919191919","Dhaka","Male"));
        users.add(new User("Sakib","elias@gmail.com","01919191919","Dhaka","Male"));
        return users;
    }

}

