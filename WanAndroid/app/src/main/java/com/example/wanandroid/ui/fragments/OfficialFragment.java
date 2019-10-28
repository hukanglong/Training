package com.example.wanandroid.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.adapters.VpAdapter;
import com.example.wanandroid.adapters.VpTitlesAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.AuthorBean;
import com.example.wanandroid.beans.OfficialBean;
import com.example.wanandroid.mvp.presenter.OfficialPresenter;
import com.example.wanandroid.mvp.view.OfficialView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfficialFragment extends BaseFragment<OfficialPresenter> implements OfficialView {


    @BindView(R.id.tab_official)
    TabLayout mTabOfficial;
    @BindView(R.id.vp_official)
    ViewPager mVpOfficial;
    Unbinder unbinder;
    List<AuthorBean.DataBean> mDataBeans = new ArrayList<>();
    private int id = 0;
    private String name = "鸿洋";
    private ArrayList<String> mTitles;

    public OfficialFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        OfficialFragment fragment = new OfficialFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected OfficialPresenter initPresenter() {
        return new OfficialPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_official;
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    protected void initView() {
        initTabs();
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            fragments.add(TwoFragment.newInstance(mTitles.get(i)));
        }
        VpTitlesAdapter vpTitlesAdapter = new VpTitlesAdapter(getChildFragmentManager(), getActivity(), fragments, mTitles);
        mVpOfficial.setAdapter(vpTitlesAdapter);
        mTabOfficial.setupWithViewPager(mVpOfficial);
    }

    private void initTabs() {
        mTitles = new ArrayList<>();
        mTitles.add("鸿洋");
        mTitles.add("郭霖");
        mTitles.add("玉刚说");
        mTitles.add("承香墨影");
        mTitles.add("Android群英传");
        mTitles.add("code小生");
        mTitles.add("谷歌开发者");
        mTitles.add("奇卓社");
        mTitles.add("美团技术团队");
        mTitles.add("GcsSloop");
        mTitles.add("互联网侦探");
        mTitles.add("susion随心");
        mTitles.add("程序亦非猿");
        mTitles.add("Gityuan");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }

}
