package com.vladborisov.demofragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    public static final String TAG = "ListFragment";
    private List<Item> items;
    private OnListSelectedListener listSelectedListener;
    private static Item item;

    public interface OnListSelectedListener {
        void onListSelected(Item item);
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_list_of_elements, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate ");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        items = generateItemList();
        setupRecyclerView(getView());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnListSelectedListener) {
            listSelectedListener = (OnListSelectedListener) context;
        } else {
            System.out.println("Class cast expansion");
        }
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    private List<Item> generateItemList() {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= MainActivity.COUNT_ITEM_GEN; i++) {
            items.add(new Item(MainActivity.ITEM_TEXT, i));
        }
        return items;
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.list_item_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new ItemAdapter(LayoutInflater.from(getActivity()), items));
    }

    /*private void onItemClick(Item item) {
        ListFragment.item = item;
    }*/

    private void onElementListClick(Item item) {
        listSelectedListener.onListSelected(item);
    }
}
