package com.meghanil.ganpatiaarto;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;

/**
 Created by anil on 25/8/16.
 */
public class Util {

    public static String APP_ID = "ca-app-pub-5744041098060478~5757625391";

    public static void setTypeFace(TextView tv,Context context) {
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP) {
            Typeface tf = Typeface.createFromAsset(context.getResources().getAssets(), "kiran.ttf");
            tv.setTypeface(tf);
        }
    }
}
