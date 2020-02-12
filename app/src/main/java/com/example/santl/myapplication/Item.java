package com.example.santl.myapplication;

/**
 * Created by santl on 28-01-2020.
 */

public class Item {
    public String item_img;

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public void setItem_seller(String item_seller) {
        this.item_seller = item_seller;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String item_name;
    public String item_description;
    public String item_seller;
    public String item_price;


    public String getItem_img() {
        return item_img;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public String getItem_seller() {
        return item_seller;
    }

    public String getItem_price() {
        return item_price;
    }
}
