package com.example.wanandroid.ui.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.wanandroid.beans.ProBean;

import java.util.ArrayList;

public class VpDataAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private ArrayList<ProBean.DataBean> mList;

    public VpDataAdapter(FragmentManager fm, Context context, ArrayList<ProBean.DataBean> list) {
        super(fm);
        mContext = context;
        mList = list;
    }

    @Override
    public Fragment getItem(int i) {
        return ProjectDetialFragment.newInstance(mList.get(i).getId());
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).getName();
    }
}
