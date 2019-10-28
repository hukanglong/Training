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
import com.example.wanandroid.adapters.KnowDateilAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.KnowDateilBean;
import com.example.wanandroid.mvp.presenter.KnowDateilPresenter;
import com.example.wanandroid.mvp.view.KnowDateilView;
import com.example.wanandroid.ui.activitys.OfficialDateilActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class KnowDateilFragment extends BaseFragment<KnowDateilPresenter> implements KnowDateilView {

    int id = 0;
    int cid = 0;
    public ArrayList<KnowDateilBean.DataBean.DatasBean> mList = new ArrayList<>();
    @BindView(R.id.rec_know)
    RecyclerView mRecKnow;
    Unbinder unbinder;
    private KnowDateilAdapter mKnowDateilAdapter;

    public KnowDateilFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance(int id) {
        KnowDateilFragment fragment = new KnowDateilFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected KnowDateilPresenter initPresenter() {
        return new KnowDateilPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_know_dateil;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        cid = id;
        mRecKnow.setLayoutManager(new LinearLayoutManager(getActivity()));
        mKnowDateilAdapter = new KnowDateilAdapter(getActivity(),mList);
        mRecKnow.setAdapter(mKnowDateilAdapter);

        mKnowDateilAdapter.setMyOnclick(new KnowDateilAdapter.MyOnclick() {
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
    protected void initData() {
        mPresenter.getData(id, cid);
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void setData(KnowDateilBean bean) {
        List<KnowDateilBean.DataBean.DatasBean> datas = bean.getData().getDatas();
        mList.addAll(datas);
        mKnowDateilAdapter.notifyDataSetChanged();
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
