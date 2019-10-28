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
import com.example.wanandroid.adapters.ProAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.ProDateilBean;
import com.example.wanandroid.mvp.presenter.ProDateilPresenter;
import com.example.wanandroid.mvp.view.ProDateilView;
import com.example.wanandroid.ui.activitys.OfficialDateilActivity;
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
public class ProjectDetialFragment extends BaseFragment<ProDateilPresenter> implements ProDateilView {

    @BindView(R.id.rlv_pro)
    RecyclerView mRlvPro;
    Unbinder unbinder;
    @BindView(R.id.smart_pro)
    SmartRefreshLayout mSmartPro;
    private List<ProDateilBean.DataBean.DatasBean> mList = new ArrayList<>();
    int id = 0;
    private int mCid;
    private ProAdapter mProAdapter;

    public ProjectDetialFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance(int id) {
        ProjectDetialFragment fragment = new ProjectDetialFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected ProDateilPresenter initPresenter() {
        return new ProDateilPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project_dateil;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        mCid = bundle.getInt("id");
        mRlvPro.setLayoutManager(new LinearLayoutManager(getActivity()));
        mProAdapter = new ProAdapter(getActivity(), mList);
        mRlvPro.setAdapter(mProAdapter);

        mSmartPro.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                id++;
                mPresenter.getData(id,mCid);
            }
        });
        mSmartPro.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                id = 0;
                mList.clear();
                mPresenter.getData(id,mCid);
            }
        });

        mProAdapter.setMyOnclick(new ProAdapter.MyOnclick() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), OfficialDateilActivity.class);
                intent.putExtra("url",mList.get(position).getLink());
                intent.putExtra("title",mList.get(position).getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
        unbinder.unbind();
    }

    @Override
    protected void initData() {
        mPresenter.getData(id, mCid);
    }

    @Override
    public void setData(ProDateilBean bean) {
        mList.addAll(bean.getData().getDatas());
        mProAdapter.notifyDataSetChanged();
        mSmartPro.finishRefresh().finishLoadMore();
    }

    @Override
    public void setMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
