package com.meghanil.ganpatiaarto;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.appbrain.AdId;
import com.appbrain.AppBrain;
import com.appbrain.InterstitialBuilder;
import com.meghanil.ganpatiaarto.adapter.AartiListAdapter;

public class AartiList extends AppCompatActivity {
    FloatingActionButton fab;
    RecyclerView aartiList;
    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppBrain.init(this);
        setContentView(R.layout.aarti_list);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        init();
        AppRater.app_launched(this);
    }

    private void init() {

        aartiList = (RecyclerView) findViewById(R.id.aartiList);
        aartiList.setLayoutManager(new LinearLayoutManager(this));
        AartiListAdapter adapter =new AartiListAdapter(this);
        aartiList.setAdapter(adapter);
        if(!checkPermission()){
            requestPermission();
        }
    }

    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        if (result == PackageManager.PERMISSION_GRANTED){

            return true;

        } else {

            return false;

        }
    }

    private void requestPermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.INTERNET)){

            Toast.makeText(this,"internet permission of new updated data of Aarti.",Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
            },MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this,"internet permission of new updated data of Aarti.",Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(this,"fail.",Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0
                || !InterstitialBuilder.create().setAdId(AdId.EXIT).setFinishOnExit(this).show(this)) {
            super.onBackPressed();
        }
    }

}
