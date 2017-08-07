package com.meghanil.ganpatiaarto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity    {
    NestedScrollView nested;
    public static String TTITTL="tittle";
    public static String DESCRIPTION="description";
    public static  String  IMAGE="image";
    public static  String  POSITION="POSITION";
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
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        String description = data.getString(DESCRIPTION,null);
        if(description!=null){
            ((TextView)findViewById(R.id.description)).setText(description);
        }

        int  imgId = data.getInt(IMAGE,-1);
        if(imgId!=-1) {
        //    Picasso.with(this).load(imgId).into((ImageView) findViewById(R.id.imgID));
        }
        nested = (NestedScrollView) findViewById(R.id.nested);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.share) {
            String shareBody = (String) ((TextView)findViewById(R.id.description)).getText();
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getSupportActionBar().getTitle());
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, null));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
