package com.meghanil.ganpatiaarto

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.InterstitialAd
import com.facebook.ads.InterstitialAdListener
import com.meghanil.ganpatiaarto.adapter.AartiListAdapter
import kotlinx.android.synthetic.main.aarti_list.*


class AartiList : AppCompatActivity() {
    lateinit var interstitialAd: InterstitialAd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aarti_list)
        init()
        AppRater.app_launched(this)

        Log.d(TAG,"onCreate END")
    }

    private fun init() {
        aartiList.layoutManager = LinearLayoutManager(this)
        val adapter = AartiListAdapter(this)
        aartiList.adapter = adapter
        interstitialAd = InterstitialAd(this, "2416433748619591_2417702178492748")


        interstitialAd.setAdListener(object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad?) {
                // Interstitial ad displayed callback

                Log.e(TAG, "Interstitial ad displayed.")
            }

            override fun onInterstitialDismissed(ad: Ad?) {
                // Interstitial dismissed callback

                finish()
                Log.e(TAG, "Interstitial ad dismissed.")
            }

            override fun onError(ad: Ad?, adError: AdError) {
                // Ad error callback

                Log.e(TAG, "Interstitial ad failed to load: " + adError.errorMessage)
            }

            override fun onAdLoaded(ad: Ad?) {
                // Interstitial ad is loaded and ready to be displayed

                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!")
                // Show the ad



            }

            override fun onAdClicked(ad: Ad?) {
                // Ad clicked callback

                Log.d(TAG, "Interstitial ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad?) {
                // Ad impression logged callback

                Log.d(TAG, "Interstitial ad impression logged!")
            }
        })

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown


        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd()
    }

    override fun onBackPressed() {
        if(interstitialAd.isAdLoaded){
            interstitialAd.show()
        }else {
            super.onBackPressed()
        }
    }
    companion object {
        const val TAG = "AartiList"
    }

}
