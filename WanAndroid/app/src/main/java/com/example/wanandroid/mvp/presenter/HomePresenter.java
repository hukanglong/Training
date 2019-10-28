package com.example.wanandroid.mvp.presenter;

import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.beans.BannerBean;
import com.example.wanandroid.beans.ListBean;
import com.example.wanandroid.mvp.model.HomeModel;
import com.example.wanandroid.mvp.view.HomeView;
import com.example.wanandroid.util.ResultCallBack;

public class HomePresenter extends BasePresenter<HomeView> {

    private HomeModel mHomeModel;

    @Override
    protected void initModel() {
        mHomeModel = new HomeModel();
        addModel(mHomeModel);
    }

    public void getList(int id){
        mHomeModel.getListData(id,new ResultCallBack<ListBean>() {
            @Override
            public void onSuccess(ListBean bean) {
                if (bean!=null){
                    if(mView!=null){
                        mView.setData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                mView.setToast(msg);
            }
        });
    }

    public void getBanner(){
        mHomeModel.getData(new ResultCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bean) {
                if(bean!=null){
                    if(mView!=null){
                        mView.setBanners(bean);
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
