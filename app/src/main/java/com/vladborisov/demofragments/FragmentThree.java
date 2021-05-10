package com.vladborisov.demofragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {
    private int id;
    private OnSimpleListSelectedListener onSimpleListSelectedListener;

    public interface OnSimpleListSelectedListener {
        void onSimpleListSelected(int id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //items = generateItemList();
        //setupRecyclerView(view);
        TextView tv1 = view.findViewById(R.id.tV1);
        tv1.setOnClickListener(v -> onElementListClick(tv1.getId()));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnSimpleListSelectedListener) {
            onSimpleListSelectedListener = (OnSimpleListSelectedListener) context;
        } else {
            System.out.println("Class cast expansion");
        }
    }
    private void onElementListClick(int id){onSimpleListSelectedListener.onSimpleListSelected(id);}
}
