package com.meghanil.ganpatiaarto;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.meghanil.ganpatiaarto.adapter.AartiPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {
   AartiPagerAdapter aartiPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view_pager);
        int position = getIntent().getIntExtra(MainActivity.POSITION, 0);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setOffscreenPageLimit(1);
        Log.d("ViewPagerActivity", "onCreate: "+position);
        pager.setAdapter(new AartiPagerAdapter(getSupportFragmentManager(),this));
       pager.setCurrentItem(position,true);
    }

}