package com.example.wanandroid.mvp.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.beans.OfficialBean;
import com.example.wanandroid.mvp.model.TwoModel;
import com.example.wanandroid.mvp.view.TwoView;
import com.example.wanandroid.util.ResultCallBack;

public class TwoPresenter extends BasePresenter<TwoView> {

    private TwoModel mTwoModel;

    @Override
    protected void initModel() {
        mTwoModel = new TwoModel();
        addModel(mTwoModel);
    }

    public void getData(int id,String name){
        mTwoModel.getData(id, name, new ResultCallBack<OfficialBean>() {
            @Override
            public void onSuccess(OfficialBean bean) {
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
