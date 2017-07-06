package com.meghanil.ganpatiaarto;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.inmobi.sdk.InMobiSdk;
import com.meghanil.ganpatiaarto.adapter.AartiPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view_pager);
        InMobiSdk.init(this, "fe05cc9a139d43d1b0d99ab48d16390d"); //'this' is used specify context
        int position = getIntent().getIntExtra(MainActivity.POSITION, 0);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setOffscreenPageLimit(1);
        Log.d("ViewPagerActivity", "onCreate: "+position);
        pager.setAdapter(new AartiPagerAdapter(getSupportFragmentManager(),this));
        pager.setCurrentItem(position,true);
    }

}