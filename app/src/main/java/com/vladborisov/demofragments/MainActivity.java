package com.vladborisov.demofragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentFour.OnSimpleListSelectedListener, Toolbar.OnMenuItemClickListener, ListFragment.OnListSelectedListener {
    public static final int COUNT_ITEM_GEN = 20;
    public static final String ITEM_TEXT = "Элемент списка номер";

    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup viewGroup = findViewById(R.id.activity_main_container);
        View view = LayoutInflater.from(this).inflate(R.layout.toolbar, viewGroup, false);
        viewGroup.addView(view);
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ListFragment listFragment = new ListFragment();
                FragmentTwo fragmentTwo = new FragmentTwo();
                FragmentFour fragmentFour = new FragmentFour();
                FragmentThree fragmentThree = new FragmentThree();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (tab.getPosition() == 0) {
                    fragmentTransaction
                            .replace(R.id.activity_main_fragment_container, fragmentThree, "FRAGMENT FOUR");
                } else if (tab.getPosition() == 1) {
                    fragmentTransaction
                            .replace(R.id.activity_main_fragment_container, fragmentTwo, "FRAGMENT TWO");
                } else if (tab.getPosition() == 2) {
                    fragmentTransaction
                            .replace(R.id.activity_main_fragment_container, listFragment, "FRAGMENT TWO");
                }
                fragmentTransaction.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    private List<Item> generateItemList() {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= MainActivity.COUNT_ITEM_GEN; i++) {
            items.add(new Item(MainActivity.ITEM_TEXT, i));
        }
        return items;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        if (id == R.id.fragment_two) {
            FragmentTwo fragmentTwo = new FragmentTwo();
            fragmentManager
                    .replace(R.id.activity_main_fragment_container, fragmentTwo, "FRAGMENT TWO")
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.fragment_three) {
            FragmentFour fragmentFour = new FragmentFour();
            fragmentManager
                    .replace(R.id.activity_main_fragment_container, fragmentFour, "FRAGMENT TWO")
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.fragment_four) {
            fragmentManager
                    .replace(R.id.activity_main_fragment_container, ListElementDetailed.newInstance("item.name + " + " + item.count"), ListElementDetailed.TAG)
                    .addToBackStack(null)
                    .commit();
        }
        return true;
    }

    @Override
    public void onSimpleListSelected(int id) {
        if (id == R.id.tV1) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main_fragment_container, ListElementDetailed.newInstance(id + " int"), ListElementDetailed.TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }

    private void onItemClick(Item item) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListSelected(Item item) {
        //Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show();
    }
}