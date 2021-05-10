package com.vladborisov.demofragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListElementDetailed extends Fragment {
    public static final String TAG = "ListElementDetailed";
    private static final String EXTRA_TEXT = "EXTRA_TEXT";

    public static ListElementDetailed newInstance(String text){
        ListElementDetailed fragment = new ListElementDetailed();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_info_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null){
            String text = getArguments().getString(EXTRA_TEXT, "...");
            ((TextView) view.findViewById(R.id.fragment_show_info_item_text)).setText(text);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
}
