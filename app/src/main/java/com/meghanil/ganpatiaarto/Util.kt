package com.meghanil.ganpatiaarto

import android.content.Context
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.os.Build
import android.widget.TextView

/**
 * Created by anil on 25/8/16.
 */
object Util {
   /* var APP_ID = "ca-app-pub-1356977967417348~2517610118"
    var isLoadSecond = false
    fun setTypeFace(tv: TextView, context: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            val tf = Typeface.createFromAsset(context.resources.assets, "kiran.ttf")
            tv.typeface = tf
        }
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }*/

    const val TITLE = "title"
    const val DESCRIPTION = "description"
    const val IMAGE = "image"
    const val POSITION = "POSITION"
}