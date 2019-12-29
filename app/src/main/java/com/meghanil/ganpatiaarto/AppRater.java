package com.meghanil.ganpatiaarto;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.appcompat.app.AppCompatDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
  Created by anil on 14/9/16.
 */
public class AppRater {
    private static  String APP_TITLE = "Aarti";// App Name
    private final static String APP_PNAME = MainActivity.class.getPackage().getName();// Package Name

    private final static int DAYS_UNTIL_PROMPT = 10;//Min number of days
    private final static int LAUNCHES_UNTIL_PROMPT = 10;//Min number of launches
    private static SharedPreferences prefs;
    public static void app_launched(Context mContext) {
        prefs = mContext.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) { return ; }
        APP_TITLE = mContext.getString(R.string.app_name);
        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch +
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(mContext, editor);
            }
        }
        editor.commit();
    }

    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        final Dialog dialog = new AppCompatDialog(mContext,android.R.style.Theme_DeviceDefault_Dialog);
        dialog.setTitle("Rate " + APP_TITLE);

        View root = LayoutInflater.from(mContext).inflate(R.layout.app_rate,null);

        TextView tv = (TextView) root.findViewById(R.id.rate_msg);
        tv.setText("If you enjoy using " + APP_TITLE + ", please take a moment to rate it. Thanks for your support!");


        Button b1 = (Button)root.findViewById(R.id.app_rate_btn);
        b1.setText("Rate " + APP_TITLE);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
                dialog.dismiss();
            }
        });

        Button b2 = (Button)root.findViewById(R.id.remind);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(prefs!=null){
                    prefs.edit().putLong("launch_count", 0).apply();
                }
                dialog.dismiss();
            }
        });

        Button b3 = (Button)root.findViewById(R.id.no_thanks);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });

        dialog.setContentView(root);

        dialog.show();
    }
}