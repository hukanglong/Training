package com.example.wanandroid.mvp.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.beans.ProBean;

public interface ProjectView extends BaseView {

    void setData(ProBean bean);

    void setMsg(String msg);
}
