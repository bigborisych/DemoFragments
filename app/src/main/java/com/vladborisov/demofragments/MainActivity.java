package com.vladborisov.demofragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements FragmentThree.OnSimpleListSelectedListener, Toolbar.OnMenuItemClickListener {
    public static final int COUNT_ITEM_GEN = 20;
    public static final String ITEM_TEXT = "Элемент списка номер";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTwo fragmentTwo = new FragmentTwo();
                ListFragment listFragment = new ListFragment();
                FragmentThree fragmentThree = new FragmentThree();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (tab.getPosition() == 0) {
                    fragmentTransaction
                            .replace(R.id.activity_main_fragment_container2, fragmentTwo, "FRAGMENT TWO")
                            .remove(fragmentTwo)
                            .replace(R.id.activity_main_fragment_container3, fragmentThree, "FRAGMENT THREE")
                            .remove(fragmentThree)
                            .replace(R.id.activity_main_fragment_container, listFragment, ListFragment.TAG);

                } else if (tab.getPosition() == 1) {
                    fragmentTransaction
                            .replace(R.id.activity_main_fragment_container, listFragment, ListFragment.TAG)
                            .remove(listFragment)
                            .replace(R.id.activity_main_fragment_container3, fragmentThree, "FRAGMENT THREE")
                            .remove(fragmentThree)
                            .replace(R.id.activity_main_fragment_container2, fragmentTwo, "FRAGMENT TWO");


                } else if (tab.getPosition() == 2) {
                    fragmentTransaction
                            .replace(R.id.activity_main_fragment_container, listFragment, ListFragment.TAG)
                            .remove(listFragment)
                            .replace(R.id.activity_main_fragment_container2, fragmentTwo, "FRAGMENT TWO")
                            .remove(fragmentTwo)
                            .replace(R.id.activity_main_fragment_container3, fragmentThree, "FRAGMENT THREE");

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
            FragmentThree fragmentThree = new FragmentThree();
            fragmentManager
                    .replace(R.id.activity_main_fragment_container, fragmentThree, "FRAGMENT TWO")
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

   /* @Override
    public void onListSelected(Item item) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show();
    }*/
}