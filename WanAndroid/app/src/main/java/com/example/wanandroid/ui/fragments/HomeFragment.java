package com.example.wanandroid.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.adapters.HomeAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.BannerBean;
import com.example.wanandroid.beans.ListBean;
import com.example.wanandroid.mvp.presenter.HomePresenter;
import com.example.wanandroid.mvp.view.HomeView;
import com.example.wanandroid.ui.activitys.HomeDateilActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView {


    @BindView(R.id.rlv_home)
    RecyclerView mRlvHome;
    Unbinder unbinder;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    private ArrayList<String> mBanners = new ArrayList<>();
    private ArrayList<ListBean.DataBean.DatasBean> mDataBeans = new ArrayList<>();
    private HomeAdapter mHomeAdapter;
    int mPage = 0;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getBanner();
        mPresenter.getList(mPage);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        mRlvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomeAdapter = new HomeAdapter(getActivity(), mBanners, mDataBeans);
        mRlvHome.setAdapter(mHomeAdapter);

        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPage++;
                mPresenter.getList(mPage);
            }
        });
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mDataBeans.clear();
                mPage = 0;
                mPresenter.getList(mPage);
            }
        });

        mHomeAdapter.setMyOnclick(new HomeAdapter.MyOnclick() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), HomeDateilActivity.class);
                intent.putExtra("url",mDataBeans.get(position).getLink());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }

    @Override
    public void setBanners(BannerBean bean) {
        List<BannerBean.DataBean> data = bean.getData();
        mBanners.clear();
        for (int i = 0; i < data.size(); i++) {
            mBanners.add(data.get(i).getImagePath());
        }
        mHomeAdapter.notifyDataSetChanged();
    }

    @Override
    public void setMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(ListBean bean) {
        mDataBeans.addAll(bean.getData().getDatas());
        mHomeAdapter.notifyDataSetChanged();
        //mSmart;
        mSmart.finishLoadMore().finishRefresh();

    }

    @Override
    public void setToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String msg) {

    }

}
