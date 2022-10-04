package com.junianto.ppbrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.junianto.ppbrecyclerview.DetailActivity;
import com.junianto.ppbrecyclerview.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListHandphoneAdapter extends RecyclerView.Adapter<ListHandphoneAdapter.ViewHolder> {

    private final ArrayList<String> handphoneImages;
    private final ArrayList<String> handphoneNames;
    private final ArrayList<String> handphoneMerk;
    private final ArrayList<String> handphonePrice;
    private final Context context;

    public ListHandphoneAdapter(ArrayList<String> handphoneImages, ArrayList<String> handphoneNames, ArrayList<String> handphoneMerk, ArrayList<String> handphonePrice, Context context) {
        this.handphoneImages = handphoneImages;
        this.handphoneNames = handphoneNames;
        this.handphoneMerk = handphoneMerk;
        this.handphonePrice = handphonePrice;
        this.context = context;
    }

    @NonNull
    @Override
    public ListHandphoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHandphoneAdapter.ViewHolder holder, int position) {
        Glide.with(context).asBitmap()
                .load(handphoneImages.get(position))
                .apply(new RequestOptions()
                        .override(300,300))
                .into(holder.imageViewFotoHandphone);
        holder.textViewHandphoneName.setText(handphoneNames.get(position));
        holder.textViewHandphoneMerk.setText(handphoneMerk.get(position));
        holder.textViewHandphonePrice.setText(handphonePrice.get(position));
        holder.linearLayout.setOnClickListener(view -> {
            Toast.makeText(context, handphoneNames.get(position), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("handphoneImage", handphoneImages.get(position));
            intent.putExtra("handphoneName", handphoneNames.get(position));
            intent.putExtra("handphoneMerk", handphoneMerk.get(position));
            intent.putExtra("handphonePrice", handphonePrice.get(position));

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return handphoneNames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout linearLayout;
        final ImageView imageViewFotoHandphone;
        final TextView textViewHandphoneName;
        final TextView textViewHandphoneMerk;
        final TextView textViewHandphonePrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFotoHandphone = itemView.findViewById(R.id.civHandphoneImage);
            textViewHandphoneName = itemView.findViewById(R.id.tvHandphoneName);
            textViewHandphoneMerk = itemView.findViewById(R.id.tvHandphoneMerk);
            textViewHandphonePrice = itemView.findViewById(R.id.tvHandphonePrice);
            linearLayout = itemView.findViewById(R.id.itemLinearLayout);
        }
    }
}
