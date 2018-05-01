package com.oliver.testapp;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.oliver.testapp.adapters.VPagerAdapter;
import com.oliver.testapp.fragments.FirstFragment;
import com.oliver.testapp.fragments.SecondFragment;
import com.oliver.testapp.klasi.Sliki;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.oliver.testapp.R.*;
import static com.oliver.testapp.R.layout.first_fragment;

public class MainActivity extends AppCompatActivity  {
    Context context;
    public VPagerAdapter adapter;
    public @BindView(id.vp)
    ViewPager vPage;
    @BindView(id.tablayout)TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        context = this;
        ButterKnife.bind(this);
        tabs.setupWithViewPager(vPage);
        adapter = new VPagerAdapter(getSupportFragmentManager());
        adapter.dodadiFragment(new FirstFragment(), "FIRST FRAGMENT");
        adapter.dodadiFragment(new SecondFragment(), "SECOND FRAGMENT");
        vPage.setAdapter(adapter);

    }

}


