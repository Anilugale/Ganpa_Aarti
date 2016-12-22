package com.meghanil.ganpatiaarto.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.meghanil.ganpatiaarto.MainActivity;
import com.meghanil.ganpatiaarto.R;
import com.meghanil.ganpatiaarto.fragment.AartiFragment;

/**
  Created by anil on 15/11/16.
 */
public class AartiPagerAdapter extends FragmentPagerAdapter {

    String[] titileData,descriptionData;
    Context context;
    TypedArray imageID;

    public AartiPagerAdapter(FragmentManager fragmentManager, Context context){
        super(fragmentManager);
        this.context = context;
        titileData = context.getResources().getStringArray(R.array.tittle);
        descriptionData = context.getResources().getStringArray(R.array.description);
        imageID = context.getResources().obtainTypedArray(R.array.imageArray);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {


        AartiFragment fm =   new AartiFragment();
        Bundle main = new Bundle();
        main.putString(MainActivity.TTITTL, titileData[position]);
        main.putString(MainActivity.DESCRIPTION, descriptionData[position]);
        main.putInt(MainActivity.IMAGE, imageID.getResourceId(position, -1));
        fm.setArguments(main);
        return fm;


    }

    @Override
    public int getCount() {
        return titileData.length;
    }
}
