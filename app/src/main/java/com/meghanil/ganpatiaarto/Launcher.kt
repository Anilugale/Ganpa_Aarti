package com.meghanil.ganpatiaarto

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.facebook.ads.AdSettings
import com.facebook.ads.AudienceNetworkAds

class Launcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        AdSettings.setDebugBuild(BuildConfig.DEBUG)
        AudienceNetworkAds.initialize(this)
        findViewById<View>(R.id.card).postDelayed({
            val main = Intent(this@Launcher, AartiList::class.java)
            try {
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@Launcher, findViewById(R.id.card), "logo")
                startActivity(main, options.toBundle())
            } catch (e: Exception) {
                startActivity(main)
            }
            finish()
        }, 800)
    }

    override fun onBackPressed() { // your code.
    }
}