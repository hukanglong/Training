package com.example.wanandroid.mvp.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.beans.AuthorBean;
import com.example.wanandroid.mvp.model.AuthorModel;
import com.example.wanandroid.mvp.view.AboutView;
import com.example.wanandroid.mvp.view.AuthorView;
import com.example.wanandroid.util.ResultCallBack;

public class AuthorPresenter extends BasePresenter<AuthorView> {

    private AuthorModel mAuthorModel;

    @Override
    protected void initModel() {
        mAuthorModel = new AuthorModel();
        addModel(mAuthorModel);
    }

    public void getData(){
        mAuthorModel.getAuthorData(new ResultCallBack<AuthorBean>() {
            @Override
            public void onSuccess(AuthorBean bean) {
                if(bean != null){
                    if(mView!=null){
                        mView.setData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                mView.setMsg(msg);
            }
        });
    }
}
