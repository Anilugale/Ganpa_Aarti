package com.meghanil.ganpatiaarto.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inmobi.ads.InMobiBanner;
import com.inmobi.sdk.InMobiSdk;
import com.meghanil.ganpatiaarto.R;
import com.meghanil.ganpatiaarto.ViewPagerActivity;
import com.squareup.picasso.Picasso;

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
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.activity_main, container, false);
      description =(TextView) rootView.findViewById(R.id.description);
      txtTtitle =(TextView) rootView.findViewById(R.id.title);
      imageView =(ImageView) rootView.findViewById(R.id.image);
      nested = (NestedScrollView) rootView.findViewById(R.id.nested);
      InMobiBanner banner = (InMobiBanner)rootView.findViewById(R.id.banner);
      banner.load();
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
}