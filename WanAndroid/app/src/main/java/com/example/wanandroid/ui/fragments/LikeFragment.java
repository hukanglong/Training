package com.example.wanandroid.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.mvp.presenter.LikePresenter;
import com.example.wanandroid.mvp.presenter.WanAndroidPresenter;
import com.example.wanandroid.mvp.view.LikeView;
import com.example.wanandroid.mvp.view.WanAndroidView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LikeFragment extends BaseFragment<LikePresenter> implements LikeView {


    public LikeFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        LikeFragment fragment = new LikeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected LikePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_like;
    }

    @Override
    public void showToast(String msg) {

    }
}
