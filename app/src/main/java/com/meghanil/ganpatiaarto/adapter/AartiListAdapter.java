package com.meghanil.ganpatiaarto.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
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

/**
   Created by anil on 25/8/16.
 */
public class AartiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String[] titileData,descriptionData;
    static int main =1,ad=2;

    public AartiListAdapter(Context context) {
        this.context = context;
        titileData = context.getResources().getStringArray(R.array.tittle);
        descriptionData = context.getResources().getStringArray(R.array.description);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType ==main) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.arrtilist_item, parent, false));
        }else{
            return new AdViewHolder(LayoutInflater.from(context).inflate(R.layout.ad_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int position) {
        if(holder1.getItemViewType() == main) {
            final ViewHolder holder=(ViewHolder) holder1;
            holder.img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.g1));

            final int newposition = getPosition(position);
            Log.d("postion", "onBindViewHolder: "+newposition+ " "+position );
            holder.tittle.setText(titileData[newposition]);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent main = new Intent(context, MainActivity.class);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((AartiList) context, holder.itemView.findViewById(R.id.card), "card");
                    main.putExtra(MainActivity.TTITTL, titileData[newposition]);
                    main.putExtra(MainActivity.DESCRIPTION, descriptionData[newposition]);
                    context.startActivity(main, options.toBundle());
                }
            });
        }else{
            AdViewHolder adViewHolder=(AdViewHolder) holder1;
            MobileAds.initialize(context.getApplicationContext(), Util.APP_ID);

            AdRequest adRequest = new AdRequest.Builder()
                    .build();
            adViewHolder.mAdView.loadAd(adRequest);
        }

    }

    private int getPosition(int position) {
        if(position>4) {
            return position -(int) Math.ceil(position / 4);
        }else{
            return position;
        }
    }

    @Override
    public int getItemCount() {
        return descriptionData.length+(descriptionData.length/4);
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

    class  AdViewHolder extends RecyclerView.ViewHolder{
        AdView mAdView;
        public AdViewHolder(View itemView) {
            super(itemView);
             mAdView = (AdView) itemView.findViewById(R.id.adView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position!=0 && position%4==0){
            return ad;
        }else{
            return main;
        }
    }
}
