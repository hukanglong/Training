package com.example.wanandroid.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.wanandroid.R;
import com.example.wanandroid.adapters.VpAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.mvp.presenter.WanAndroidPresenter;
import com.example.wanandroid.mvp.view.WanAndroidView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WanAndroidFragment extends BaseFragment<WanAndroidPresenter> implements WanAndroidView {

    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tab)
    TabLayout mTab;
    Unbinder unbinder;
    private ArrayList<BaseFragment> mFragments;

    public WanAndroidFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        WanAndroidFragment fragment = new WanAndroidFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected WanAndroidPresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wan_android;
    }

    @Override
    protected void initView() {
        initFragments();
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), getActivity(), mFragments);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setText(getResources().getString(R.string.home)).setIcon(R.drawable.select_home);
        mTab.getTabAt(1).setText(getResources().getString(R.string.know)).setIcon(R.drawable.select_know_wan);
        mTab.getTabAt(2).setText(getResources().getString(R.string.official)).setIcon(R.drawable.select_official);
        mTab.getTabAt(3).setText(getResources().getString(R.string.navigation)).setIcon(R.drawable.select_navigation);
        mTab.getTabAt(4).setText(getResources().getString(R.string.project)).setIcon(R.drawable.select_project);

    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(KnowFragment.newInstance());
        mFragments.add(OfficialFragment.newInstance());
        mFragments.add(NavigationFragment.newInstance());
        mFragments.add(ProjectFragment.newInstance());
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
