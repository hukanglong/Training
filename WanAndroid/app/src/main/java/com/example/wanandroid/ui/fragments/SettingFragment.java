package com.example.wanandroid.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.mvp.presenter.SettingPresenter;
import com.example.wanandroid.mvp.presenter.WanAndroidPresenter;
import com.example.wanandroid.mvp.view.SettingView;
import com.example.wanandroid.mvp.view.WanAndroidView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends BaseFragment<SettingPresenter> implements SettingView {


    public SettingFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected SettingPresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    public void showToast(String msg) {

    }
}
