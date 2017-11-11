package com.tip.robinsonsappliances.ui.Appliances.details.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();

    }

    public void addFrag(FragmentAppliancesDetails fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    public void setFragmentTiles(int index, String title) {
        mFragmentTitleList.set(index, title);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}