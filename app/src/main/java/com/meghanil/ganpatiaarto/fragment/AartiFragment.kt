package com.meghanil.ganpatiaarto.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.meghanil.ganpatiaarto.R
import com.meghanil.ganpatiaarto.Util
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by anil on 15/11/16.
 */

class AartiFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            val adView = AdView(activity!!, "2416433748619591_2416439661952333", AdSize.BANNER_HEIGHT_50)
            banner_container.addView(adView)
            adView.loadAd()
        }
        init()
    }

    private fun init() {
        val data = arguments
        val tittle = data!!.getString(Util.TITLE, null)
        titleView.text = tittle

        val description1 = data.getString(Util.DESCRIPTION, null)
        if (description1 != null) {
            this.description.text = description1
        }
        val imgId = data.getInt(Util.IMAGE, -1)
        if (imgId != -1) {
            Picasso.with(context).load(imgId).into(image)
        }
    }


}
 
   
  