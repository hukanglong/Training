package com.example.wanandroid.mvp.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.beans.AuthorBean;
import com.example.wanandroid.mvp.model.NavigationModel;
import com.example.wanandroid.mvp.view.NavigationView;
import com.example.wanandroid.util.ResultCallBack;

public class NavigationPresenter extends BasePresenter<NavigationView> {

    private NavigationModel mOfficialModel;

    @Override
    protected void initModel() {
        mOfficialModel = new NavigationModel();
        addModel(mOfficialModel);
    }

    public void getData(){
        mOfficialModel.getAuthorData(new ResultCallBack<AuthorBean>() {
            @Override
            public void onSuccess(AuthorBean bean) {
                if(bean!=null){
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
