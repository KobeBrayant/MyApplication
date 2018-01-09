package com.ysd.keepcar.ui.prisonframents.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * Created by 特雷西麦克格蕾蒂 on 2018/1/8.
 */

public class ProsionFragmentAdapter extends FragmentPagerAdapter {



    ArrayList<Fragment> fragmentArrayList;

    public ProsionFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.fragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
}
