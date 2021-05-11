package com.vladborisov.demofragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private final List<Item> items;
    private final LayoutInflater inflater;
    private final Listener listener;

    public ItemAdapter(LayoutInflater inflater, List<Item> items, Listener listener) {
        this.items = items;
        this.inflater = inflater;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(inflater.inflate(R.layout.list_item, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bind(items.get(position));
        /*
        holder.itemView.setOnClickListener(v -> Toast.makeText(v.getContext(),"fdsa", Toast.LENGTH_SHORT).show());*/
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface Listener {
        void onItemClick(Item item);
    }
}
