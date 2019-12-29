package com.meghanil.ganpatiaarto;

import android.content.Intent;
import androidx.core.app.ActivityOptionsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;


public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        AdSettings.setDebugBuild(BuildConfig.DEBUG);
        AudienceNetworkAds.initialize(this);


        findViewById(R.id.card).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main= new Intent(Launcher.this,AartiList.class);
					try {
						ActivityOptionsCompat options = ActivityOptionsCompat.
								  makeSceneTransitionAnimation(Launcher.this, findViewById(R.id.card), "logo");
						startActivity(main, options.toBundle());
					}catch (Exception e){
						startActivity(main);
					}
               finish();
            }
        },1500);
    }

    @Override
    public void onBackPressed() {
        // your code.
    }
}
