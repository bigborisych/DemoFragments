package com.vladborisov.demofragments;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemClickListener {
    public static final int COUNT_ITEM_GEN = 20;
    public static final String ITEM_TEXT = "Элемент списка номер";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListFragment listFragment = new ListFragment();
        listFragment.setListener(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_fragment_container, listFragment, ListFragment.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onItemClickListener(Item item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_fragment_container, ListElementDetailed.newInstance(item.name + " " + item.count), ListElementDetailed.TAG)
                .addToBackStack(null)
                .commit();
    }
}