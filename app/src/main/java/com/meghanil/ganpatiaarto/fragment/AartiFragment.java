package com.meghanil.ganpatiaarto.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
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
   private final static String TAG = AartiFragment.class.getSimpleName();
      @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.activity_main, container, false);
      description =(TextView) rootView.findViewById(R.id.description);
      txtTtitle =(TextView) rootView.findViewById(R.id.title);
      imageView =(ImageView) rootView.findViewById(R.id.image);
      nested = (NestedScrollView) rootView.findViewById(R.id.nested);
         // Instantiate a NativeBannerAd object.
         // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
         // now, while you are testing and replace it later when you have signed up.
         // While you are using this temporary code you will only get test ads and if you release
         // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
         AdView adView = new AdView(getContext(), "2416433748619591_2416439661952333", AdSize.BANNER_HEIGHT_50);

         // Find the Ad Container
         LinearLayout adContainer = (LinearLayout) rootView.findViewById(R.id.banner_container);

         // Add the ad view to your activity layout
         adContainer.addView(adView);

         // Request an ad
         adView.loadAd();
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
      }
   }
}
 
   
  