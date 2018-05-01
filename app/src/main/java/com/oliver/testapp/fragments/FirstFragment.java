package com.oliver.testapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.oliver.testapp.Prefferences.Preff;
import com.oliver.testapp.R;
import com.oliver.testapp.klasi.Sliki;
import com.oliver.testapp.model.SlikiModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;
import static com.oliver.testapp.R.drawable.carfour;
import static com.oliver.testapp.R.drawable.navigation_empty_icon;

public class FirstFragment extends Fragment {

    private Unbinder mUnbind;
    @BindView(R.id.slika)
    ImageView imageView;
    public ArrayList<Sliki> itemData2;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_fragment, null);
        mUnbind = ButterKnife.bind(this, view);
        itemData2 = new ArrayList<>();
        itemData2.add(new Sliki(R.drawable.carone));
        itemData2.add(new Sliki(R.drawable.cartwo));
        itemData2.add(new Sliki(R.drawable.carthree));
        itemData2.add(new Sliki(R.drawable.carfour));

        final int[] c = {0};
        int d = Preff.getInt(getActivity());
            Sliki sliki = itemData2.get(d);
            Picasso.with(getActivity()).load(sliki.Slika).into(imageView);
            c[0] =d;

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if (c[0] ==(itemData2.size()-1)) {
                   c[0] =0;
               } else {

                   c[0]++;
               }
                Sliki slika= itemData2.get(c[0]);
                Preff.setInt(c[0],getActivity());
                Picasso.with(getActivity()).load(slika.Slika).into(imageView);
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }
}
