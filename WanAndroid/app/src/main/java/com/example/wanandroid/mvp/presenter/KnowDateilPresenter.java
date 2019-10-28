package com.example.wanandroid.mvp.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.beans.KnowDateilBean;
import com.example.wanandroid.mvp.model.KnowDateilModel;
import com.example.wanandroid.mvp.view.AboutView;
import com.example.wanandroid.mvp.view.KnowDateilView;
import com.example.wanandroid.util.ResultCallBack;

public class KnowDateilPresenter extends BasePresenter<KnowDateilView> {

    private KnowDateilModel mKnowDateilModel;

    @Override
    protected void initModel() {
        mKnowDateilModel = new KnowDateilModel();
        addModel(mKnowDateilModel);
    }

    public void getData(int id,int cid){
        mKnowDateilModel.getKnowDatileData(id, cid, new ResultCallBack<KnowDateilBean>() {
            @Override
            public void onSuccess(KnowDateilBean bean) {
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
