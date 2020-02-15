package com.example.santl.myapplication;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class Buy_adapter extends RecyclerView.Adapter {
    private Context context;
    private LayoutInflater inflater;
    List<Item> data= Collections.emptyList();
    Item current_item;
    int currentPos=0;
    public Buy_adapter(Context context, List<Item> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.activity_buy_adapter, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder= (MyHolder) holder;
        Item current=data.get(position);
        myHolder.item_name.setText(current.getItem_name());
        myHolder.price.setText(current.getItem_price());
        myHolder.seller.setText(current.getItem_seller());
        myHolder.description.setText(current.getItem_description());
        myHolder.price.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        // load image into imageview using glide
        Glide.with(context).load(current.getItem_img())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.appicon)
                .into(myHolder.img);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
class MyHolder extends RecyclerView.ViewHolder{

    TextView item_name;
    ImageView img;
    TextView seller;
    TextView description;
    TextView price;

    // create constructor to get widget reference
    public MyHolder(View itemView) {
        super(itemView);
        item_name= (TextView) itemView.findViewById(R.id.item_name);
        img= (ImageView) itemView.findViewById(R.id.img);
        seller = (TextView) itemView.findViewById(R.id.seller);
        description = (TextView) itemView.findViewById(R.id.description);
        price = (TextView) itemView.findViewById(R.id.price_d);
    }

}