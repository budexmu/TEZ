package com.example.tez;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.library.skeleton.Master.AdapterSkeleton;
import com.example.library.skeleton.Master.IsCanSetAdapterListener;
import com.example.library.skeleton.SkeletonGroup;
import com.example.tez.Data.DataObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterSample1 extends AdapterSkeleton<DataObject,AdapterSample1.ViewHolder>{


    public AdapterSample1(final Context context, final ArrayList<DataObject> items, final RecyclerView recyclerView, final IsCanSetAdapterListener isCanSetAdapterListener) {
        this.context = context;
        this.items = items;
        this.isCanSetAdapterListener = isCanSetAdapterListener;

        measureHeightRecyclerViewAndItem(recyclerView, R.layout.layout_listitem);// Set height

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private SkeletonGroup skeletonGroup;
        private AppCompatImageView photoACImgV;
        private TextView newFlagTv;
        private TextView titleTv;
        private TextView descriptionTv;
        private AppCompatImageButton addToParkingImgBtn;
        private AppCompatImageButton compareImgBtn;
        private TextView priceTv;


        ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            skeletonGroup = (SkeletonGroup) itemView.findViewById(R.id.skeletonGroup);
            photoACImgV = (AppCompatImageView) itemView.findViewById(R.id.photoACImgV);

            titleTv = (TextView) itemView.findViewById(R.id.titleTv);

            addToParkingImgBtn = (AppCompatImageButton) itemView.findViewById(R.id.addToParkingImgBtn);

            priceTv = (TextView) itemView.findViewById(R.id.priceTv);

        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.cardView.setPreventCornerOverlap(false);

//        holder.skeletonGroup.setPosition(position);//just for debug log

        if (skeletonConfig.isSkeletonIsOn()) {
            return;
        } else {
            holder.skeletonGroup.setShowSkeleton(false);
            holder.skeletonGroup.finishAnimation();
        }

        //set data in view
        final DataObject cardObj = items.get(position);

        holder.titleTv.setText(cardObj.getTitle());
        holder.descriptionTv.setText(cardObj.getDescription());
        holder.priceTv.setText(cardObj.getPrice());

        if (cardObj.isNew()) {
            holder.newFlagTv.setVisibility(View.VISIBLE);
        } else {
            holder.newFlagTv.setVisibility(View.GONE);
        }

        //set photo by Picasso lib
        Picasso.with(context).load(cardObj.getPhoto()).into(holder.photoACImgV);

    }



}
