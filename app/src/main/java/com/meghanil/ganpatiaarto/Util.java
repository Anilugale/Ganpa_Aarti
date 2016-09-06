package com.meghanil.ganpatiaarto;

import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.widget.TextView;

/**
 Created by anil on 25/8/16.
 */
public class Util {

    public static String APP_ID = "ca-app-pub-1356977967417348~2517610118";

    public static void setTypeFace(TextView tv,Context context) {
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP) {
            Typeface tf = Typeface.createFromAsset(context.getResources().getAssets(), "kiran.ttf");
            tv.setTypeface(tf);
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
