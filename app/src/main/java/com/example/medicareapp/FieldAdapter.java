package com.example.medicareapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FieldAdapter extends RecyclerView.Adapter<FieldAdapter.ViewHolder> {

    List<Feeds> feedsList;
    Context context;

    public FieldAdapter(List<Feeds> feeds) {
        feedsList = feeds;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Feeds feed = feedsList.get(position);
        if ((feed.getField1()) >= 800) {
            holder.bubble.setText("No Bubble");
        } else {
            holder.bubble.setText("Bubbles Formed");
        }

        if ((feed.getField2()) == 12) {
            holder.depth.setText("100%");
        }
        if ((feed.getField2()) == 11) {
            holder.depth.setText("91.3%");
        }
        if ((feed.getField2()) == 10) {
            holder.depth.setText("83%");
        }
        if ((feed.getField2()) == 9) {
            holder.depth.setText("74.7%");
        }
        if ((feed.getField2()) == 8) {
            holder.depth.setText("66.4%");
        }
        if ((feed.getField2()) == 7) {
            holder.depth.setText("58.1%");
        }
        if ((feed.getField2()) == 6) {
            holder.depth.setText("49.8%");
        }
        if ((feed.getField2()) == 5) {
            holder.depth.setText("41.5%");
        }
        if ((feed.getField2()) == 4) {
            holder.depth.setText("33.2%");
        }
        if ((feed.getField2()) == 3) {
            holder.depth.setText("24.9%");
        }
        if ((feed.getField2()) == 2) {
            holder.depth.setText("16.6%");
        }
        if ((feed.getField2()) == 1) {
            holder.depth.setText("8.3%");
        }
        if ((feed.getField2()) == 0) {
            holder.depth.setText("0%");
        }
    }


    @Override
    public int getItemCount() {
        return feedsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView bubble;
        TextView depth;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bubble = itemView.findViewById(R.id.bubble);
            depth = itemView.findViewById(R.id.depth);

        }
    }
}

