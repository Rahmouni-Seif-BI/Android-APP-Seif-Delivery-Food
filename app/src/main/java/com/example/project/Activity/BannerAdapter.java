package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.R;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerHolder>
{

    /*======<<<<------ DECLARATION ------>>>>============*/
    private Context context;
    private List<Integer> urls;
    /*======<<<<------ /DECLARATION ------>>>>============*/


    public BannerAdapter(Context context, List<Integer> urls)
    {
        this.context=context;
        this.urls=urls;
    }

    @NonNull
    @Override
    public BannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_banner_item,parent,false);
        return new BannerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerHolder holder, int position)
    {
        int url=urls.get(position%urls.size());

        Glide.with(context).load(url).centerCrop().into(holder.imgBanner);
    }

    @Override
    public int getItemCount()
    {
        return urls==null?0:Integer.MAX_VALUE;
    }

    public class BannerHolder extends RecyclerView.ViewHolder
    {
        ImageView imgBanner;
        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            imgBanner=itemView.findViewById(R.id.imgBanner);
        }

    }
}
