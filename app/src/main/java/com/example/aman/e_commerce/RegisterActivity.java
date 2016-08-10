package com.example.aman.e_commerce;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aman.e_commerce.models.CustomerInfo;
import com.example.aman.e_commerce.models.SimpleRealmEx;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.aman.e_commerce.models.SimpleRealmEx.getInstance;

public class RegisterActivity extends AppCompatActivity {
    EditText etName, etPwd, etPhn, etEmail, etAdres;
    Button btRgt, btCnl;
    private Realm realm;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
       realm = Realm.getDefaultInstance();

        etName = (EditText) findViewById(R.id.etname);
        etPwd = (EditText) findViewById(R.id.etpwd);
        etPhn = (EditText) findViewById(R.id.etphn);
        etEmail = (EditText) findViewById(R.id.etemail);
        etAdres = (EditText) findViewById(R.id.etadrs);
        btRgt = (Button) findViewById(R.id.btrgt);
        btCnl = (Button) findViewById(R.id.btcnl);
       btRgt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(etName==null){
                Log.w("RegisterActivity","eName is nulll");
            }
            else {
                String name = etName.getText().toString().trim();
                String phoneNo = etPhn.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                String address = etAdres.getText().toString().trim();
                save_into_database(name, phoneNo, email, pwd, address);
                Toast.makeText(getApplicationContext(), "Success",Toast.LENGTH_SHORT).show();

            }
            // view_refresh();
        }
       });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Register Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.aman.e_commerce/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Register Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.aman.e_commerce/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
    protected void onDestroy(){
        super.onDestroy();
        realm.close();
    }
    /*public void view_refresh(){
        RealmResults<CustomerInfo> customer = realm.where(CustomerInfo.class).findAll();
     String output="";
        for (CustomerInfo cInfo:customer){
            output +=customer.toString();

        }
    }*/
public void save_into_database(final String name,final String phoneNo,final String email,final String password,final String address ){
    CustomerInfo info=new CustomerInfo();
    info.setcName(name);
    info.setcEmail(email);
    info.setcPhoneNo(phoneNo);
    info.setcPassword(password);
    info.setcAddress(address);
    realm.beginTransaction();
    realm.copyToRealmOrUpdate(info);
    realm.commitTransaction();
}
}
