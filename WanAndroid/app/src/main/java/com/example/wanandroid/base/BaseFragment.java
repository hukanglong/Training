package com.example.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liguixiao on 2019/10/11.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment
        implements BaseView {

    private Unbinder unbinder;
    public T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        unbinder = ButterKnife.bind(this, inflate);
        mPresenter = initPresenter();
        //以前是通过构造传递view，现在通过一个方法传递
        if (mPresenter != null){
            mPresenter.bindView(this);
        }
        initView();
        initData();
        initListener();
        return inflate;
    }

    protected abstract T initPresenter();

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView(){};

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        //取消网络请求，取消订阅，打断V和P的联系
//        mPresenter.destory();
        mPresenter = null;
    }

    /*@Override
    public void showToast(String msg) {
        ToastUtil.showShort(msg);
    }

    @Override
    public void showLoading() {
        //loading是一个自定义的dialog
        if (loadingDialog  == null){
            loadingDialog = new LoadingDialog(getContext());
        }
        if (!loadingDialog.isShowing()){
            loadingDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null){
            loadingDialog.dismiss();
        }
    }*/
}
