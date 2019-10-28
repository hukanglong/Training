package com.example.wanandroid.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.wanandroid.base.BaseFragment;

import java.util.ArrayList;

public class VpAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ArrayList<BaseFragment> mFragments;

    public VpAdapter(FragmentManager fm, Context context, ArrayList<BaseFragment> fragments) {
        super(fm);
        mContext = context;
        mFragments = fragments;
    }

    public VpAdapter(FragmentManager fm) {
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
}
