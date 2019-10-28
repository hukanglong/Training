package com.example.wanandroid.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.mvp.presenter.AboutPresenter;
import com.example.wanandroid.mvp.presenter.WanAndroidPresenter;
import com.example.wanandroid.mvp.view.AboutView;
import com.example.wanandroid.mvp.view.WanAndroidView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends BaseFragment<AboutPresenter> implements AboutView {


    public AboutFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected AboutPresenter initPresenter() {
        return new AboutPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    public void showToast(String msg) {

    }
}
