package com.meghanil.ganpatiaarto.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiInterstitial;
import com.meghanil.ganpatiaarto.R;
import com.meghanil.ganpatiaarto.Util;
import com.meghanil.ganpatiaarto.ViewPagerActivity;
import com.squareup.picasso.Picasso;

import java.util.Map;

/**
 Created by anil on 15/11/16.
 */

public class AartiFragment extends Fragment {
   
   NestedScrollView nested;
   public static String TTITTL="tittle";
   public static String DESCRIPTION="description";
   public static  String  IMAGE="image";
   ImageView  imageView;
   TextView description,txtTtitle;
   String tittle;
   InMobiBanner banner;
   InMobiBanner banner2;
   private final static String TAG = AartiFragment.class.getSimpleName();
      @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.activity_main, container, false);
      description =(TextView) rootView.findViewById(R.id.description);
      txtTtitle =(TextView) rootView.findViewById(R.id.title);
      imageView =(ImageView) rootView.findViewById(R.id.image);
      nested = (NestedScrollView) rootView.findViewById(R.id.nested);
      banner = (InMobiBanner)rootView.findViewById(R.id.banner);
      banner2 = (InMobiBanner)rootView.findViewById(R.id.banner2);
      
      init();
      return rootView;
   }
   
   private void init() {
      Bundle data =getArguments();
      tittle = data.getString(TTITTL,null);
      txtTtitle.setText(tittle);
      String description = data.getString(DESCRIPTION,null);
      if(description!=null){
         this.description.setText(description);
      }
      int  imgId = data.getInt(IMAGE,-1);
      if(imgId!=-1) {
         Picasso.with(getContext()).load(imgId).into(imageView);
      }
   }
   
   @Override
   public void onResume() {
      super.onResume();
      ( (ViewPagerActivity)getActivity()).setTitle(tittle);
      }
   
   private void showAd(boolean isSecond) {
      if(banner==null && banner2 == null){
         return;
      }
   
      if (isSecond) {
         banner2.load();
         
   
         banner2.setListener(new InMobiBanner.BannerAdListener() {
      
      
            @Override
            public void onAdLoadSucceeded(InMobiBanner inMobiBanner) {
               
            }
      
            @Override
            public void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus) {
               Log.e("", "onAdLoadFailed:  banner2 " + inMobiAdRequestStatus.getMessage());
               banner2.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                     
                     showAd(false);
                  }
               }, 1000 * 10);
            }
      
            @Override
            public void onAdDisplayed(InMobiBanner inMobiBanner) {
         
            }
      
            @Override
            public void onAdDismissed(InMobiBanner inMobiBanner) {
         
            }
      
            @Override
            public void onAdInteraction(InMobiBanner inMobiBanner, Map<Object, Object> map) {
         
            }
      
            @Override
            public void onUserLeftApplication(InMobiBanner inMobiBanner) {
         
            }
      
            @Override
            public void onAdRewardActionCompleted(InMobiBanner inMobiBanner, Map<Object, Object> map) {
         
            }
         });
         
      } else {
      
         banner.load();
         banner.setListener(new InMobiBanner.BannerAdListener() {
         
         
            @Override
            public void onAdLoadSucceeded(InMobiBanner inMobiBanner) {
               
            }
         
            @Override
            public void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus) {
               Log.e("", "onAdLoadFailed: banner " + inMobiAdRequestStatus.getMessage());
               banner.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                     
                     showAd(true);
                  }
               }, 1000 * 10);
            }
         
            @Override
            public void onAdDisplayed(InMobiBanner inMobiBanner) {
            
            }
         
            @Override
            public void onAdDismissed(InMobiBanner inMobiBanner) {
            
            }
         
            @Override
            public void onAdInteraction(InMobiBanner inMobiBanner, Map<Object, Object> map) {
            
            }
         
            @Override
            public void onUserLeftApplication(InMobiBanner inMobiBanner) {
            
            }
         
            @Override
            public void onAdRewardActionCompleted(InMobiBanner inMobiBanner, Map<Object, Object> map) {
            
            }
         });
      
      }
   
   }
   
   @Override
   public void setUserVisibleHint(boolean isVisibleToUser) {
      super.setUserVisibleHint(isVisibleToUser);
      if(isVisibleToUser) {
         if(Util.isLoadSecond){
            Util.isLoadSecond = false;
         }else{
            Util.isLoadSecond = true;
         }
         Log.e(TAG, "setUserVisibleHint: "+ Util.isLoadSecond );
         showAd( Util.isLoadSecond);
      }
   }
}
 
   
  