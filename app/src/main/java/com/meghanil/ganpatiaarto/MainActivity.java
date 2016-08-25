package com.meghanil.ganpatiaarto;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    NestedScrollView nested;
    public static String TTITTL="tittle";
    public static String DESCRIPTION="description";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        init();

    }

    private void init() {


        Bundle data =getIntent().getExtras();
        String tittle = data.getString(TTITTL,null);
        if(tittle!=null) {
            getSupportActionBar().setTitle(tittle);
        }
        String description = data.getString(DESCRIPTION,null);
        if(description!=null){
            ((TextView)findViewById(R.id.description)).setText(description);
        }
        fab = (FloatingActionButton) findViewById(R.id.fab);
        nested = (NestedScrollView) findViewById(R.id.nested);
        nested.setSmoothScrollingEnabled(true);


        nested.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (oldScrollX >0) {
                    // Scroll Down
                    if (fab.isShown()) {
                        fab.hide();
                    }
                }
                else if (oldScrollY <0) {
                    // Scroll Up
                    if (!fab.isShown()) {
                        fab.show();
                    }
                }
            }
        });

        MobileAds.initialize(getApplicationContext(), Util.APP_ID);

        AdView mAdView = (AdView) findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mAdView.loadAd(adRequest);
    }



}
