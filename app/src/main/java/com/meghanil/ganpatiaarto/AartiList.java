package com.meghanil.ganpatiaarto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aarti_list);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        init();

    }

    private void init() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        aartiList = (RecyclerView) findViewById(R.id.aartiList);
        aartiList.setLayoutManager(new LinearLayoutManager(this));
        AartiListAdapter adapter =new AartiListAdapter(this);
        aartiList.setAdapter(adapter);

    }



}
