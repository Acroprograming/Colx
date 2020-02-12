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

import java.util.List;

public class BuyRecycleAdapter extends RecyclerView.Adapter<BuyRecycleAdapter.ItemViewHolder> {


    //this context we will use to inflate the layout
    private Context context;

    //we are storing all the Items in a list
    private List<Item> ItemList;

    //getting the context and Item list with constructor
    public BuyRecycleAdapter(Context mCtx, List<Item> ItemList) {
        this.context = mCtx;
        this.ItemList = ItemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder myHolder, int position) {
        //getting the Item of the specified position
        Item current = ItemList.get(position);

        //binding the data with the viewholder views
        myHolder.item_name.setText(current.getItem_name());

        myHolder.price.setText(current.getItem_price());
        myHolder.seller.setText(current.getItem_seller());
        myHolder.description.setText(current.getItem_description());


// load image into imageview using glide
        Glide.with(context).load(current.getItem_img())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.appicon)
                .into(myHolder.img);

    }


    @Override
    public int getItemCount() {
        return ItemList.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView item_name;
        ImageView img;
        TextView seller;
        TextView description;
        TextView price;

        public ItemViewHolder(View itemView) {
            super(itemView);

            item_name= (TextView) itemView.findViewById(R.id.item_name);
            img= (ImageView) itemView.findViewById(R.id.img);
            seller = (TextView) itemView.findViewById(R.id.seller);
            description = (TextView) itemView.findViewById(R.id.description);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }
}