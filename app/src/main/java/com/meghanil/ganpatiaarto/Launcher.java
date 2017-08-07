package com.meghanil.ganpatiaarto;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.inmobi.sdk.InMobiSdk;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        InMobiSdk.init(this, "9b284bc268e24470a9ce2d982619f851"); //'this' is used specify context
    
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
