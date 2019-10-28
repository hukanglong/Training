package com.example.wanandroid.mvp.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.beans.ProBean;
import com.example.wanandroid.mvp.model.ProjectModel;
import com.example.wanandroid.mvp.view.AboutView;
import com.example.wanandroid.mvp.view.ProjectView;
import com.example.wanandroid.util.ResultCallBack;

public class ProjectPresenter extends BasePresenter<ProjectView> {

    private ProjectModel mProjectModel;

    @Override
    protected void initModel() {
        mProjectModel = new ProjectModel();
        addModel(mProjectModel);
    }

    public void getData(){
        mProjectModel.getPro(new ResultCallBack<ProBean>() {
            @Override
            public void onSuccess(ProBean bean) {
                if (bean!=null){
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
