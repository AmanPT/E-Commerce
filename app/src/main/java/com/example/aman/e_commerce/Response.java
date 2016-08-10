package com.example.aman.e_commerce;

import io.realm.RealmObject;

/**
 * Created by Aman on 31-Jul-16.
 */
public class Response extends RealmObject{
public static class ProductList{
    String product_pic;
    String product_name;
    String product_price;
    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public String getProduct_pic() {
        return product_pic;
    }

    public void setProduct_pic(String product_pic) {
        this.product_pic = product_pic;
    }



}
}
