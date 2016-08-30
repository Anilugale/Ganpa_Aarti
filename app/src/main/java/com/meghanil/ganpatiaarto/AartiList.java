package com.meghanil.ganpatiaarto;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.meghanil.ganpatiaarto.adapter.AartiListAdapter;

public class AartiList extends AppCompatActivity {
    FloatingActionButton fab;
    RecyclerView aartiList;
    public static int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aarti_list);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        init();

    }

    private void init() {

        aartiList = (RecyclerView) findViewById(R.id.aartiList);
        aartiList.setLayoutManager(new LinearLayoutManager(this));
        AartiListAdapter adapter =new AartiListAdapter(this);
        aartiList.setAdapter(adapter);
        checkPremistion();
    }

    private void checkPremistion() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{ Manifest.permission.INTERNET},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }



}
