package com.example.wanandroid.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.adapters.TwoAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.OfficialBean;
import com.example.wanandroid.mvp.presenter.TwoPresenter;
import com.example.wanandroid.mvp.view.TwoView;
import com.example.wanandroid.ui.activitys.OfficialDateilActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends BaseFragment<TwoPresenter> implements TwoView {


    @BindView(R.id.rlv_two)
    RecyclerView mRlvTwo;
    Unbinder unbinder;
    int id = 1;
    String mName = "鸿洋";
    private ArrayList<OfficialBean.DataBean.DatasBean> mList = new ArrayList<>();

    public TwoFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance(String name) {
        TwoFragment fragment = new TwoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected TwoPresenter initPresenter() {
        return new TwoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        mName = name;
        mRlvTwo.setLayoutManager(new LinearLayoutManager(getActivity()));
        TwoAdapter twoAdapter = new TwoAdapter(getActivity(), mList);
        mRlvTwo.setAdapter(twoAdapter);

        twoAdapter.setMyOnclick(new TwoAdapter.MyOnclick() {
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
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }

    @Override
    protected void initData() {
        mPresenter.getData(id,mName);
    }

    @Override
    public void setData(OfficialBean bean) {
        mList.addAll(bean.getData().getDatas());
    }

    @Override
    public void setMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
