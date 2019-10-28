package com.example.wanandroid.mvp.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.beans.KnowBean;
import com.example.wanandroid.mvp.model.KnowModel;
import com.example.wanandroid.mvp.view.AboutView;
import com.example.wanandroid.mvp.view.KnowView;
import com.example.wanandroid.util.ResultCallBack;

public class KnowPresenter extends BasePresenter<KnowView> {

    private KnowModel mKnowModel;

    @Override
    protected void initModel() {
        mKnowModel = new KnowModel();
        addModel(mKnowModel);
    }

    public void getDatas(){
        mKnowModel.getData(new ResultCallBack<KnowBean>() {
            @Override
            public void onSuccess(KnowBean bean) {
                if(bean!=null){
                    if(mView!=null){
                        mView.setKnowData(bean);
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
