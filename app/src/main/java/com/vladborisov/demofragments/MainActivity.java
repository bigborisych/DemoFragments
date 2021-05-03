package com.vladborisov.demofragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int COUNT_ITEM_GEN = 20;
    public static final String ITEM_TEXT = "Элемент списка номер";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_fragment_container, new ListFragment(), ListFragment.TAG)
                .addToBackStack(null)
                .commit();

    }


}