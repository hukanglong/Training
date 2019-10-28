package com.example.wanandroid.mvp.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.beans.BannerBean;
import com.example.wanandroid.beans.ListBean;

public interface HomeView extends BaseView {

    void setBanners(BannerBean bean);

    void setMsg(String msg);

    void setData(ListBean bean);

    void setToast(String msg);
}
