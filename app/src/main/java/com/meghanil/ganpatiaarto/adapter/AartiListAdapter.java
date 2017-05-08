package com.meghanil.ganpatiaarto.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.meghanil.ganpatiaarto.AartiList;
import com.meghanil.ganpatiaarto.MainActivity;
import com.meghanil.ganpatiaarto.R;
import com.meghanil.ganpatiaarto.Util;
import com.meghanil.ganpatiaarto.ViewPagerActivity;
import com.squareup.picasso.Picasso;

/**
 Created by anil on 25/8/16.
 */
public class AartiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String[] titileData,descriptionData;
    TypedArray imageID;
    static int main =1,ad=2;

    public AartiListAdapter(Context context) {
        this.context = context;
        titileData = context.getResources().getStringArray(R.array.tittle);
        descriptionData = context.getResources().getStringArray(R.array.description);
        imageID = context.getResources().obtainTypedArray(R.array.imageArray);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.arrtilist_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int position) {
        if(holder1.getItemViewType() == main) {
            final ViewHolder holder=(ViewHolder) holder1;

            final int newposition = getPosition(position);
            //Util.setTypeFace(holder.tittle,context);
            holder.tittle.setText(Html.fromHtml(titileData[newposition]));
            Picasso.with(context).load(imageID.getResourceId(newposition, -1)).into(holder.img);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent main = new Intent(context, ViewPagerActivity.class);

                    Pair<View, String> pair1 = Pair.create( holder.itemView.findViewById(R.id.card), "card");
                    Pair<View, String> pair2 = Pair.create(holder.itemView.findViewById(R.id.img),"logo");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((AartiList) context,pair1,pair2);

                    main.putExtra(MainActivity.TTITTL, titileData[newposition]);
                    main.putExtra(MainActivity.DESCRIPTION, descriptionData[newposition]);
                    main.putExtra(MainActivity.IMAGE, imageID.getResourceId(newposition, -1));
                    main.putExtra(MainActivity.POSITION, newposition);
                    context.startActivity(main, options.toBundle());
                }
            });
        }

    }

    private int getPosition(int position) {
       /* if(position>4) {
            return position -(int) Math.ceil(position / 4);
        }else{
            return position;
        }*/
    
        return position;
    }

    @Override
    public int getItemCount() {
              //  return descriptionData.length+(descriptionData.length/4)+1;
    
        return descriptionData.length;
    }

    class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tittle;
        public ViewHolder(View itemView) {
            super(itemView);
            img =(ImageView)itemView.findViewById(R.id.img);
            tittle =(TextView) itemView.findViewById(R.id.tittle);
        }
    }

 

    @Override
    public int getItemViewType(int position) {
      /*  if(position!=0 && position%4==0){
            return ad;
        }else{
            return main;
        }*/
        return main;
    }
}
