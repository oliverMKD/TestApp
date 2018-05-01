package com.oliver.testapp.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.oliver.testapp.fragments.FirstFragment;

import java.util.ArrayList;

//import com.oliver.mymovies.fragmenti.Popular;

/**
 * Created by Oliver on 2/6/2018.
 */

public class VPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmenti = new ArrayList<Fragment>();
    ArrayList<String> titles = new ArrayList<>();

    public void dodadiFragment (Fragment fragment, String titlovi){
        fragmenti.add(fragment);
        titles.add(titlovi);
    }

    public VPagerAdapter(FragmentManager fm) {
        super(fm);

    }
    @Override
    public int getCount() {
        return fragmenti.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
    @Override
    public Fragment getItem(int position) {
        return fragmenti.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


}
