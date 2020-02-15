package com.example.santl.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Buy_recyclerview extends AppCompatActivity {
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    private RecyclerView recyclerView;
    private BuyRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_recyclerview);
        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Item> data = new ArrayList<>();
        try {
            String json = getIntent().getExtras().getString("json_data");
            JSONArray jArray;
            JSONObject jsonObject = new JSONObject(json);
            jArray = jsonObject.getJSONArray("items");
            // Extract data from json and store into ArrayList as class objects
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Item item = new Item();
                item.item_name = json_data.getString("item_name");
                item.item_description = json_data.getString("description");
                item.item_img = json_data.getString("img");
                item.item_seller = json_data.getString("seller");
                item.item_price = json_data.getString("price");
                String json_data_seller = json_data.getJSONObject("0").toString();
                item.seller_desc=json_data_seller;
                data.add(item);
                System.out.print(item.seller_desc);
            }
            adapter = new BuyRecycleAdapter(this, data);
            recyclerView.setAdapter(adapter);

        } catch (JSONException e) {

            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void to_sell_screen(View view) {
        Intent intent = new Intent(this,Sell.class);
        this.startActivity(intent);
    }


}