package com.example.admin.syntechsolution;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2/8/2019.
 */

public class CustomAdapter extends ArrayAdapter {
    List arrayListUser=new ArrayList();

    public CustomAdapter(@NonNull Context c, int resource) {
        super(c, resource);
    }

    /*public CustomAdapter(Context c, ArrayList<User> arrayListUser) {
        this.c = c;
        this.arrayListUser = arrayListUser;
    }*/

    public void add(User object){
        super.add(object);
        arrayListUser.add(object);
    }
    @Override
    public int getCount() {
        return arrayListUser.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListUser.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parents) {
        View row;
        row=convertView;
        UserHolder userHolder;
        if (row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.list_item_layout,parents,false);
            userHolder=new UserHolder();
            userHolder.tvName=row.findViewById(R.id.tvUserName);
            userHolder.tvPhone=row.findViewById(R.id.tvPhoneNO);
            row.setTag(userHolder);
        }else {
            userHolder= (UserHolder) row.getTag();
        }
        User user= (User) this.getItem(position);
        userHolder.tvName.setText(" Name  = "+user.getName());
        userHolder.tvPhone.setText(" Phone = "+user.getPhone());
        return row;
    }
    static class UserHolder{
        TextView tvName,tvPhone;
    }
}

