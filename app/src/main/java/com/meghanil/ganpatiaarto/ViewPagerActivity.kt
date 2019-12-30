package com.meghanil.ganpatiaarto

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.meghanil.ganpatiaarto.adapter.AartiPagerAdapter

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_view_pager)
        val position = intent.getIntExtra(Util.POSITION, 0)
        val pager = findViewById<View>(R.id.viewPager) as ViewPager
        pager.offscreenPageLimit = 1
        Log.d("ViewPagerActivity", "onCreate: $position")
        pager.adapter = AartiPagerAdapter(supportFragmentManager, this)
        pager.setCurrentItem(position, true)
    }
}