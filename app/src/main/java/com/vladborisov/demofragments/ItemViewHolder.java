package com.vladborisov.demofragments;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView textTextView;
    private final ItemAdapter.Listener listener;

    public ItemViewHolder(@NonNull View itemView, ItemAdapter.Listener listener) {
        super(itemView);
        this.textTextView = itemView.findViewById(R.id.list_item_text);
        this.listener = listener;
    }

    public void bind(@NonNull Item item) {
        String text = item.name + " " + item.count;
        textTextView.setText(text);
        itemView.setOnClickListener(v -> listener.onItemClick(item));
    }
}
