package com.example.wanandroid.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.adapters.KnowAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.KnowBean;
import com.example.wanandroid.mvp.presenter.KnowPresenter;
import com.example.wanandroid.mvp.view.KnowView;
import com.example.wanandroid.ui.activitys.KnowDateilActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class KnowFragment extends BaseFragment<KnowPresenter> implements KnowView {


    @BindView(R.id.rlv_know)
    RecyclerView mRlvKnow;
    Unbinder unbinder;
    private List<KnowBean.DataBean> mDataBeans = new ArrayList<>();
    private KnowAdapter mKnowAdapter;

    public KnowFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        KnowFragment fragment = new KnowFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected KnowPresenter initPresenter() {
        return new KnowPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_know;
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    protected void initData() {
        mPresenter.getDatas();
    }

    @Override
    protected void initView() {
        mRlvKnow.setLayoutManager(new LinearLayoutManager(getActivity()));
        mKnowAdapter = new KnowAdapter(getActivity(), mDataBeans);
        mRlvKnow.setAdapter(mKnowAdapter);

        mKnowAdapter.setMyOnclic(new KnowAdapter.MyOnclic() {
            @Override
            public void onClick(int position) {
                KnowBean.DataBean dataBean = mDataBeans.get(position);
                Intent intent = new Intent(getActivity(), KnowDateilActivity.class);
                EventBus.getDefault().postSticky(dataBean);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }

    @Override
    public void setKnowData(KnowBean bean) {
        mDataBeans.addAll(bean.getData());
        mKnowAdapter.notifyDataSetChanged();
    }

    @Override
    public void setMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
