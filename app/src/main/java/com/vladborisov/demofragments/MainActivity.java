package com.vladborisov.demofragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int COUNT_ITEM_GEN = 10;
    private static final String ITEM_TEXT = "Елемент списка номер";
    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = generateItemList();
        setupRecyclerView();
    }

    private List<Item> generateItemList() {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= COUNT_ITEM_GEN; i++) {
            items.add(new Item(ITEM_TEXT, i));
        }
        return items;
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.list_item_recycler_view);
        ItemAdapter itemAdapter = new ItemAdapter(items);
        recyclerView.setAdapter(itemAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}