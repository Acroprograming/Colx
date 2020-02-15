package com.example.santl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Seller_description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_description);
        String json = getIntent().getExtras().getString("json_obj");
        String img=getIntent().getExtras().getString("img");
        try {
            JSONObject jsonObject = new JSONObject(json);
            String item_name = getIntent().getExtras().getString("item_name");
            String price = getIntent().getExtras().getString("price");
            String desc = getIntent().getExtras().getString("desc");
            String fname=jsonObject.getString("fname");
            String lname=jsonObject.getString("lname");
            String year=jsonObject.getString("year");
            String Class=jsonObject.getString("Class");
            String section=jsonObject.getString("section");
            String mobile_no=jsonObject.getString("mobile_no");
            String email=jsonObject.getString("email");
            ImageView imgview=(ImageView) findViewById(R.id.imageView);

            TextView item_d=findViewById(R.id.Item_name);
            TextView price_d=findViewById(R.id.price_d);
            TextView desc_d=findViewById(R.id.desc_d);
            TextView seller_d=findViewById(R.id.seller_d);
            TextView year_d=findViewById(R.id.year_d);
            TextView Class_d=findViewById(R.id.Class_d);
            TextView mobile_d=findViewById(R.id.mobile_no_d);
            TextView email_d=findViewById(R.id.email_d);

            item_d.setText(item_name);
            price_d.setText(price);
            desc_d.setText(desc);
            seller_d.setText(fname+" "+lname);
            year_d.setText((year));
            Class_d.setText(Class+" "+section);
            mobile_d.setText(mobile_no);
            email_d.setText(email);
            Glide.with(this).load(img)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.appicon)
                    .into(imgview);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
