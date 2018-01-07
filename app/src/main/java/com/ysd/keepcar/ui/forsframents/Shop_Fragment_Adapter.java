package com.ysd.keepcar.ui.forsframents;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 刘贵河 on 2018/1/5.
 */

public class Shop_Fragment_Adapter extends FragmentPagerAdapter {
    private ArrayList<String> list;
    private ArrayList<Fragment> fragmentslist;

    public Shop_Fragment_Adapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> fragmentslist) {
        super(fm);
        this.list = list;
        this.fragmentslist = fragmentslist;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentslist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentslist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return list.get(position);
    }
}
