package com.example.wanandroid.ui.activitys;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseActivity;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.base.BasePresenter;
import com.example.wanandroid.ui.fragments.AboutFragment;
import com.example.wanandroid.ui.fragments.LikeFragment;
import com.example.wanandroid.ui.fragments.SettingFragment;
import com.example.wanandroid.ui.fragments.WanAndroidFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private static final int TYPE_PLAY = 0;
    private static final int TYPE_KNOW = 1;
    private static final int TYPE_LIKE = 2;
    private static final int TYPE_KEYWORD = 3;
    private FragmentManager manager;
    private ArrayList<BaseFragment> mFragments;
    private int mLastFragmentPosition;
    private ArrayList<String> mTitles;
    private TextView mToolbarTitle;
    private Toolbar mToolbar;
    private FrameLayout mFrag;
    private NavigationView mNv;
    private DrawerLayout mDl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    protected void initView() {
        mToolbarTitle = findViewById(R.id.toolbar_title);
        mToolbar = findViewById(R.id.toolbar);
        mFrag = findViewById(R.id.frag);
        mNv = findViewById(R.id.nv);
        mDl = findViewById(R.id.dl);
        mToolbarTitle.setText("玩android");
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mToolbar, R.string.app_name, R.string.app_name);
        mDl.addDrawerListener(toggle);
        mNv.setItemIconTintList(null);
        toggle.syncState();
        manager = getSupportFragmentManager();
        initFragments();
        initTitles();
        addFragment();

        initOnclick();

    }

    private void addFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        //replace = remove + add()
        transaction.add(R.id.frag, mFragments.get(0));
        transaction.commit();
    }

    private void initOnclick() {
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId != R.id.info) {
                    menuItem.setChecked(true);
                } else {
                    menuItem.setChecked(false);
                }
                //侧滑菜单消失
                mDl.closeDrawer(Gravity.LEFT);
                switch (itemId) {
                    case R.id.play:
                        chooseFragment(TYPE_PLAY);
                        break;
                    case R.id.know:
                        chooseFragment(TYPE_KNOW);
                        break;
                    case R.id.like:
                        chooseFragment(TYPE_LIKE);
                        break;
                    case R.id.keyword:
                        chooseFragment(TYPE_KEYWORD);
                        break;
                }
                return false;
            }
        });
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add("玩Android");
        mTitles.add("设置");
        mTitles.add("收藏");
        mTitles.add("关于我们");

    }

    private void initFragments() {

        mFragments = new ArrayList<>();
        mFragments.add(WanAndroidFragment.newInstance());
        mFragments.add(SettingFragment.newInstance());
        mFragments.add(LikeFragment.newInstance());
        mFragments.add(AboutFragment.newInstance());

    }

    private void chooseFragment(int type) {

        FragmentTransaction tr = manager.beginTransaction();
        BaseFragment showFragment = mFragments.get(type);
        BaseFragment hideFragment = mFragments.get(mLastFragmentPosition);
        if (!showFragment.isAdded()) {
            //一个Fragment只能添加一次，否则会崩
            tr.add(R.id.frag, showFragment);
        }
        //隐藏上一个
        //这次显示的fragment，就是下一次要隐藏的Fragment
        tr.hide(hideFragment);
        tr.show(showFragment);

        tr.commit();

        //记录当前的Fragment索引，方便下次隐藏
        mLastFragmentPosition = type;

        //切换标题
        mToolbarTitle.setText(mTitles.get(type));

    }

}
