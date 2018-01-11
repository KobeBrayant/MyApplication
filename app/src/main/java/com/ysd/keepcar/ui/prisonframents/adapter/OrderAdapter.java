package com.ysd.keepcar.ui.prisonframents.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

/**
 * Created by 特雷西麦克格蕾蒂 on 2018/1/10.
 */

public class OrderAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    ArrayList<String> str;

    public OrderAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> str) {
        super(fm);
        this.fragments = fragments;
        this.str = str;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
