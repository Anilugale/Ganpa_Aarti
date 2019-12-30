package com.meghanil.ganpatiaarto.adapter

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import com.meghanil.ganpatiaarto.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.arrtilist_item.view.*

/**
 * Created by anil on 25/8/16.
 */
@Suppress("DEPRECATION")
class AartiListAdapter(private var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var titileData: Array<String> = context.resources.getStringArray(R.array.tittle)
    private var descriptionData: Array<String> = context.resources.getStringArray(R.array.description)
    private var imageID: TypedArray = context.resources.obtainTypedArray(R.array.imageArray)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.arrtilist_item, parent, false))
    }

    override fun onBindViewHolder(holder1: RecyclerView.ViewHolder, position: Int) {
        if (holder1.itemViewType == main) {
            val holder = holder1 as ViewHolder
            val newposition = getPosition(position)
            //Util.setTypeFace(holder.tittle,context);
            holder.itemView.tittle.text = Html.fromHtml(titileData[newposition])
            Picasso.with(context).load(imageID.getResourceId(newposition, -1)).into(holder.itemView.img)
            holder.itemView.setOnClickListener {
                val main = Intent(context, ViewPagerActivity::class.java)
                val pair1 = Pair.create(holder.itemView.findViewById<View>(R.id.card), "card")
                val pair2 = Pair.create(holder.itemView.findViewById<View>(R.id.img), "logo")
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation((context as AartiList), pair1, pair2)
                main.putExtra(Util.TITLE, titileData[newposition])
                main.putExtra(Util.DESCRIPTION, descriptionData[newposition])
                main.putExtra(Util.IMAGE, imageID.getResourceId(newposition, -1))
                main.putExtra(Util.POSITION, newposition)
                context.startActivity(main, options.toBundle())
            }
        }
    }

    private fun getPosition(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return descriptionData.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemViewType(position: Int): Int {
           return main
    }

    companion object {
        const val main = 1
    }

}