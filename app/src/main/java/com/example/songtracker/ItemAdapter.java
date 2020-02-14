package com.example.songtracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Item> itemList;

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView nameView;
        public TextView dateView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.line1);
            dateView = itemView.findViewById(R.id.line2);
        }
    }

    public ItemAdapter(ArrayList<Item> mItemList){
        itemList = mItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ItemViewHolder evh = new ItemViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        Item currItem = itemList.get(i);
        holder.nameView.setText(currItem.getName());
        holder.dateView.setText(currItem.getDate());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
