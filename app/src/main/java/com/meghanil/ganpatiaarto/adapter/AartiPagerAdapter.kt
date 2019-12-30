package com.meghanil.ganpatiaarto.adapter

import android.content.Context
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.meghanil.ganpatiaarto.R
import com.meghanil.ganpatiaarto.Util
import com.meghanil.ganpatiaarto.fragment.AartiFragment

/**
 * Created by anil on 15/11/16.
 */
class AartiPagerAdapter(fragmentManager: FragmentManager?, var context: Context) : FragmentPagerAdapter(fragmentManager!!) {
    private var titileData: Array<String> = context.resources.getStringArray(R.array.tittle)
    private var descriptionData: Array<String> = context.resources.getStringArray(R.array.description)
    private var imageID: TypedArray = context.resources.obtainTypedArray(R.array.imageArray)
    override fun getItem(position: Int): Fragment {
        val fm = AartiFragment()
        val main = Bundle()
        main.putString(Util.DESCRIPTION, descriptionData[position])
        main.putString(Util.TITLE, titileData[position])
        main.putInt(Util.IMAGE, imageID.getResourceId(position, -1))
        fm.arguments = main
        return fm
    }

    override fun getCount(): Int {
        return titileData.size
    }

}