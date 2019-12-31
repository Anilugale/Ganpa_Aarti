package com.meghanil.ganpatiaarto

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog

/**
 * Created by anil on 14/9/16.
 */
object AppRater {
    private var APP_TITLE = "Aarti" // App Name
    private val APP_PNAME = MainActivity::class.java.getPackage()!!.name // Package Name
    private const val DAYS_UNTIL_PROMPT = 10 //Min number of days
    private const val LAUNCHES_UNTIL_PROMPT = 10 //Min number of launches
    private var prefs: SharedPreferences? = null
    fun appLaunched(mContext: Context) {
        prefs = mContext.getSharedPreferences("apprater", 0)
        if (prefs!!.getBoolean("dontshowagain", false)) {
            return
        }
        APP_TITLE = mContext.getString(R.string.app_name)
        val editor = prefs!!.edit()
        val launchCount = prefs!!.getLong("launch_count", 0) + 1
        editor.putLong("launch_count", launchCount)
        var dateFirstLaunch = prefs!!.getLong("date_firstlaunch", 0)
        if (dateFirstLaunch == 0L) {
            dateFirstLaunch = System.currentTimeMillis()
            editor.putLong("date_firstlaunch", dateFirstLaunch)
        }
        if (launchCount >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= dateFirstLaunch +
                    DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000) {
                showRateDialog(mContext, editor)
            }
        }
        showRateDialog(mContext, editor)
        editor.apply()
    }

    @SuppressLint("InflateParams", "SetTextI18n")
    fun showRateDialog(mContext: Context, editor: Editor?) {
        val dialog: Dialog = AppCompatDialog(mContext)
        dialog.setTitle("Rate $APP_TITLE")
        val root = LayoutInflater.from(mContext).inflate(R.layout.app_rate, null)
        val tv = root.findViewById<View>(R.id.rate_msg) as TextView
        tv.text = "If you enjoy using $APP_TITLE, please take a moment to rate it. Thanks for your support!"
        val b1 = root.findViewById<View>(R.id.app_rate_btn) as Button
        b1.text = "Rate $APP_TITLE"
        b1.setOnClickListener {
            mContext.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$APP_PNAME")))
            dialog.dismiss()
        }
        val b2 = root.findViewById<View>(R.id.remind) as Button
        b2.setOnClickListener {
            if (prefs != null) {
                prefs!!.edit().putLong("launch_count", 0).apply()
            }
            dialog.dismiss()
        }
        val b3 = root.findViewById<View>(R.id.no_thanks) as Button
        b3.setOnClickListener {
            if (editor != null) {
                editor.putBoolean("dontshowagain", true)
                editor.commit()
            }
            dialog.dismiss()
        }
        dialog.setContentView(root)
        dialog.show()
    }
}