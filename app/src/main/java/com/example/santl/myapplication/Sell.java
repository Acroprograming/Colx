package com.example.santl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
    }

    public void sell(View view) {
        EditText item_name = findViewById(R.id.item_name);
        EditText description = findViewById(R.id.description);
        String item_name1 = item_name.getText().toString();
        String desc = description.getText().toString();
        String type="sell";
        Background backgroundSell = new Background(this);
        backgroundSell.execute(type,item_name1,desc);
    }
}
