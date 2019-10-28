package com.example.wanandroid.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.adapters.VpTitlesAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.ProBean;
import com.example.wanandroid.mvp.presenter.ProjectPresenter;
import com.example.wanandroid.mvp.view.ProjectView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends BaseFragment<ProjectPresenter> implements ProjectView {

    @BindView(R.id.tab_pro)
    TabLayout mTabPro;
    @BindView(R.id.vp_pro)
    ViewPager mVpPro;
    Unbinder unbinder;
    private ArrayList<ProBean.DataBean> mList = new ArrayList<>();
    private VpDataAdapter mVpDataAdapter;

    public ProjectFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        ProjectFragment fragment = new ProjectFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ProjectPresenter initPresenter() {
        return new ProjectPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initView() {

        mVpDataAdapter = new VpDataAdapter(getChildFragmentManager(), getActivity(), mList);
        mVpPro.setAdapter(mVpDataAdapter);
        mTabPro.setupWithViewPager(mVpPro);

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    public void setData(ProBean bean) {
        List<ProBean.DataBean> data = bean.getData();
        mList.addAll(data);
        mVpDataAdapter.notifyDataSetChanged();
    }

    @Override
    public void setMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
