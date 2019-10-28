package com.example.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{

    private T mPresenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        //以前是通过构造传递view，现在通过一个方法传递
        if (mPresenter != null){
            mPresenter.bindView(this);
        }
        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected void initView(){}

    protected void initData(){}

    protected abstract T initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消网络请求，取消订阅，打断V和P的联系
        mPresenter.destory();
        mPresenter = null;
    }

}
