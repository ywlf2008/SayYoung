package com.yw.sayyoung.sayyoung.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class OrderPageAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragmentList;
    String[] mTabs;


    public OrderPageAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] items) {
        super(fm);
        this.mTabs = items;
        this.mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }
}
