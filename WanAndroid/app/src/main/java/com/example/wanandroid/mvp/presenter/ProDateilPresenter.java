package com.example.wanandroid.mvp.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.beans.ProDateilBean;
import com.example.wanandroid.mvp.model.ProDateilModel;
import com.example.wanandroid.mvp.view.AboutView;
import com.example.wanandroid.mvp.view.ProDateilView;
import com.example.wanandroid.util.ResultCallBack;

public class ProDateilPresenter extends BasePresenter<ProDateilView> {

    private ProDateilModel mProDateilModel;

    @Override
    protected void initModel() {
        mProDateilModel = new ProDateilModel();
        addModel(mProDateilModel);
    }

    public void getData(int id,int cid){
        mProDateilModel.getPro(id, cid, new ResultCallBack<ProDateilBean>() {
            @Override
            public void onSuccess(ProDateilBean bean) {
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
