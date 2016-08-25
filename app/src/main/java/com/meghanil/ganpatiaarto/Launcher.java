package com.meghanil.ganpatiaarto;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        findViewById(R.id.card).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main= new Intent(Launcher.this,AartiList.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(Launcher.this, findViewById(R.id.card), "logo");
                startActivity(main, options.toBundle());
                finish();
            }
        },1500);
    }

    @Override
    public void onBackPressed() {
        // your code.
    }
}
