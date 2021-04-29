package com.example.tugaspmb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class KpopActivity extends Fragment {

    private RecyclerView recyclerViewVacay;

    private List<BandsModel> models = new ArrayList<>();

    public static KpopActivity newInstance() {
        KpopActivity fragment = new KpopActivity();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_kpop, container, false);
        recyclerViewVacay = (RecyclerView) view.findViewById(R.id.rv);
        recyclerViewVacay.setHasFixedSize(true);
        models.addAll(BandsDatabase.getListData());
        recyclerViewVacay.setLayoutManager(new LinearLayoutManager(getContext()));
        BandsAdapter adapter = new BandsAdapter(models);
        recyclerViewVacay.setAdapter(adapter);
        return view;
    }
}