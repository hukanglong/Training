package com.example.wanandroid.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.AuthorBean;
import com.example.wanandroid.mvp.presenter.AuthorPresenter;
import com.example.wanandroid.mvp.view.AuthorView;
import com.zhy.view.flowlayout.FlowLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AuthorFragment extends BaseFragment<AuthorPresenter> implements AuthorView {


    @BindView(R.id.title_author)
    TextView mTitleAuthor;
    @BindView(R.id.flow)
    FlowLayout mFlow;
    Unbinder unbinder;
    private ArrayList<String> flows = new ArrayList<>();
    private LinearLayout.LayoutParams mLayoutParams;

    public AuthorFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance(String title) {
        AuthorFragment fragment = new AuthorFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected AuthorPresenter initPresenter() {
        return new AuthorPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_author;
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        mTitleAuthor.setText(title);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            list.add("Android");
            list.add("Java");
            list.add("IOS");
            list.add("python");
        }
        mLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLayoutParams.setMargins(15, 10, 15, 10);
        if (mFlow != null) {
            mFlow.removeAllViews();
        }
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(getActivity());
            tv.setTextSize(20);
            tv.setPadding(50, 20, 50, 20);
            tv.setText(list.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
            tv.setBackgroundResource(R.color.gray);
            tv.setLayoutParams(mLayoutParams);
            mFlow.addView(tv, mLayoutParams);
        }
        //点击按钮将输入框内的内容添加到流式布局
        /*bnEditMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTopMain.getText())) {
                    Toast.makeText(getActivity(), "搜索内容为空，请输入内容", Toast.LENGTH_SHORT).show();
                } else {
                    TextView tv = new TextView(getActivity());
                    tv.setPadding(28, 10, 28, 10);
                    tv.setText(editTopMain.getText());
                    tv.setMaxEms(10);
                    tv.setSingleLine();
                    tv.setBackgroundResource(R.color.colorPrimary);
                    tv.setLayoutParams(mLayoutParams);
                    flowLayoutMain.addView(tv, mLayoutParams);
                }
            }
        });*/

        //给布局设置监听
        /*linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                linearLayout.setFocusable(true);
                linearLayout.setFocusableInTouchMode(true);
                linearLayout.requestFocus();
                return false;
            }
        });*/
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getMsg(List<AuthorBean.DataBean.ArticlesBean> list){
        for (int i = 0; i < list.size(); i++) {
            Log.i("tag", "getMsg: "+list.get(i).getTitle());
            flows.add(list.get(i).getTitle());
        }

    }

    @Override
    public void setData(AuthorBean bean) {

    }

    @Override
    public void setMsg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }
}
