package com.oliver.testapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oliver.testapp.R;
import com.oliver.testapp.adapters.RecyclerAdapter;
import com.oliver.testapp.klasi.Prasanja;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SecondFragment extends Fragment {

    private Unbinder mUnbind;
    @BindView(R.id.MyRV)
    RecyclerView rv;
    RecyclerAdapter adapter;
    ArrayList<Prasanja> mPrasanja;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.second_fragment, null);
        mUnbind = ButterKnife.bind(this, view);

        mPrasanja = new ArrayList<>();
        mPrasanja.add(new Prasanja("  music"));
        mPrasanja.add(new Prasanja("  Lights"));
        mPrasanja.add(new Prasanja("  TV"));

        rv.setHasFixedSize(true);
        adapter = new RecyclerAdapter(getActivity(),mPrasanja);
        rv.setLayoutManager(new GridLayoutManager(getActivity(),1));
        rv.setAdapter(adapter);

        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }
}
