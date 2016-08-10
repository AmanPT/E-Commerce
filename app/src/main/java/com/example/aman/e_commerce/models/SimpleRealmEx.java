package com.example.aman.e_commerce.models;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Aman on 08-Aug-16.
 */
public class SimpleRealmEx extends Application {
    private static SimpleRealmEx instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RealmConfiguration config = new RealmConfiguration.Builder(getApplicationContext()).build();
        Realm.setDefaultConfiguration(config);
    }
    public static SimpleRealmEx getInstance() {
        return instance;
    }
}
