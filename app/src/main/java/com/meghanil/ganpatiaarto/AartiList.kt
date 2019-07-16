package com.meghanil.ganpatiaarto

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

import com.meghanil.ganpatiaarto.adapter.AartiListAdapter
import kotlinx.android.synthetic.main.aarti_list.*

class AartiList : AppCompatActivity() {

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
    }

    companion object {
        const val TAG = "AartiList"
    }

}
