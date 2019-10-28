package com.example.wanandroid.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.wanandroid.base.BaseFragment;

import java.util.ArrayList;

public class VerticalVpAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<String> mTabs;

    public VerticalVpAdapter(FragmentManager fm, Context context, ArrayList<BaseFragment> fragments, ArrayList<String> tabs) {
        super(fm);
        mContext = context;
        mFragments = fragments;
        mTabs = tabs;
    }

    public VerticalVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String s = mTabs.get(position);
        return s;
    }
}
