package com.meghanil.ganpatiaarto;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.meghanil.ganpatiaarto.adapter.AartiListAdapter;

import java.util.Map;

public class AartiList extends AppCompatActivity {
    FloatingActionButton fab;
    RecyclerView aartiList;
    final String TAG = AartiList.class.getSimpleName();
    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.aarti_list);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        init();
        AppRater.app_launched(this);
    }

    private void init() {

        aartiList = (RecyclerView) findViewById(R.id.aartiList);
        aartiList.setLayoutManager(new LinearLayoutManager(this));
        AartiListAdapter adapter =new AartiListAdapter(this);
        aartiList.setAdapter(adapter);
        if(!checkPermission()){
            requestPermission();
        }
       initad();
    }

    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        if (result == PackageManager.PERMISSION_GRANTED){

            return true;

        } else {

            return false;

        }
    }

    private void requestPermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.INTERNET)){

            Toast.makeText(this,"internet permission of new updated data of Aarti.",Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
            },MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this,"internet permission of new updated data of Aarti.",Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(this,"fail.",Toast.LENGTH_LONG).show();

                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
       
       if(interstitial.isReady() && !IsAdShown) {
          IsAdShown = true;
          interstitial.show();
       }else{
          super.onBackPressed();
       }
    }
   
   
   InMobiInterstitial interstitial;
   boolean IsAdShown;
   void initad(){
        interstitial = new InMobiInterstitial(this, 1502038406688L, new InMobiInterstitial.InterstitialAdListener() {
          @Override
          public void onAdRewardActionCompleted(InMobiInterstitial ad, Map rewards) {
             callFinish();
          }
          @Override
          public void onAdDisplayed(InMobiInterstitial ad) {}
          @Override
          public void onAdDismissed(InMobiInterstitial ad) {
             callFinish();
          }
          @Override
          public void onAdInteraction(InMobiInterstitial ad, Map params) {}
          @Override
          public void onAdLoadSucceeded(final InMobiInterstitial ad) {
             Log.e(TAG, "onAdLoadSucceeded: "+ad );
          }
          @Override
          public void onAdLoadFailed(InMobiInterstitial ad, InMobiAdRequestStatus requestStatus) {
             Log.e(TAG, "onAdLoadFailed: "+requestStatus.getMessage() );
          }
          @Override
          public void onUserLeftApplication(InMobiInterstitial ad){}
       });
       interstitial.load();
    }
    
    private void callFinish() {
         finish();
    }
    
    
}
