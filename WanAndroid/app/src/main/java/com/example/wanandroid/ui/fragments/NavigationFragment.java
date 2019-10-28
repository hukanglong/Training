package com.example.wanandroid.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.adapters.VerticalVpAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.AuthorBean;
import com.example.wanandroid.mvp.presenter.NavigationPresenter;
import com.example.wanandroid.mvp.view.NavigationView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends BaseFragment<NavigationPresenter> implements NavigationView {


    @BindView(R.id.tab_navigation)
    VerticalTabLayout mTabNavigation;
    @BindView(R.id.vp_navigation)
    ViewPager mVpNavigation;
    Unbinder unbinder;
    private List<AuthorBean.DataBean> mList = new ArrayList<>();
    private ArrayList<String> mTabs;
    private ArrayList<BaseFragment> mFragments;
    private VerticalVpAdapter mVpAdapter;

    public NavigationFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        NavigationFragment fragment = new NavigationFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected NavigationPresenter initPresenter() {
        return new NavigationPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initView() {
        initVp();
        initTab();
        mVpAdapter = new VerticalVpAdapter(getChildFragmentManager(), getActivity(), mFragments, mTabs);
        mVpNavigation.setAdapter(mVpAdapter);
        mTabNavigation.setupWithViewPager(mVpNavigation);

    }

    private void initTab() {
        mTabs = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            mTabs.add(mList.get(i).getName());
        }
    }

    private void initVp() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            mFragments.add(AuthorFragment.newInstance(mList.get(i).getName()));
            EventBus.getDefault().postSticky(mList.get(i));
        }
    }

    @Override
    public void setData(AuthorBean bean) {
        mList.addAll(bean.getData());
        mVpAdapter.notifyDataSetChanged();
    }

    @Override
    public void setMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }
}
