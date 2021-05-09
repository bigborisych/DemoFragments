package com.vladborisov.demofragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
                .commit();
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
            if (id == R.id.fragment_two){
                FragmentTwo fragmentTwo = new FragmentTwo();
                fragmentManager.replace(R.id.activity_main_fragment_container, fragmentTwo, "FRAGMENT TWO").addToBackStack(null).commit();
            }else if(id == R.id.fragment_three){
                FragmentThree fragmentThree = new FragmentThree();
                fragmentManager.replace(R.id.activity_main_fragment_container, fragmentThree, "FRAGMENT TWO").addToBackStack(null).commit();
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
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