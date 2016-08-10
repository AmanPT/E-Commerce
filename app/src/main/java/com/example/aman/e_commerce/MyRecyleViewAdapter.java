package com.example.aman.e_commerce;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman on 31-Jul-16.

 */
public class MyRecyleViewAdapter extends RecyclerView.Adapter {

    Context ctx;
    ArrayList<Response.ProductList> productList;
    RecyclerView recyclerView;

    public MyRecyleViewAdapter(Context ctx, ArrayList<Response.ProductList> productList) {
        this.ctx = ctx;
        this.productList = productList;
    }

    public MyRecyleViewAdapter() {

    }


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        View view = LayoutInflater.from(ctx).inflate(R.layout.row_layout,null);
        return new MyProductHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyProductHolder myProductHolder = (MyProductHolder) holder;
        Picasso.with(ctx).load(productList.get(position).getProduct_pic()).into(((MyProductHolder) holder).imgPic);
        myProductHolder.price.setText(productList.get(position).getProduct_price());
        myProductHolder.pName.setText(productList.get(position).getProduct_name());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class MyProductHolder extends RecyclerView.ViewHolder
    {
        public ImageView imgPic;
        public TextView price,pName;
        public Button button;

        public MyProductHolder(View itemView)
        {
            super(itemView);

            imgPic = (ImageView) itemView.findViewById(R.id.image_view);
            price = (TextView) itemView.findViewById(R.id.textView);
            pName = (TextView) itemView.findViewById(R.id.textView2);
           button = (Button) itemView.findViewById(R.id.button);


        }

    }}
