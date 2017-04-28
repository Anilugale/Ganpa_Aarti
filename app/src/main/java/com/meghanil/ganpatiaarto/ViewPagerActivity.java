package com.meghanil.ganpatiaarto;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.meghanil.ganpatiaarto.adapter.AartiPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view_pager);
        int position = getIntent().getIntExtra(MainActivity.POSITION, 0);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setOffscreenPageLimit(3);
        Log.d("ViewPagerActivity", "onCreate: "+position);
        pager.setAdapter(new AartiPagerAdapter(getSupportFragmentManager(),this));
        pager.setCurrentItem(position,true);
    }

}
