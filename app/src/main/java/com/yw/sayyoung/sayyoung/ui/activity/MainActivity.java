package com.yw.sayyoung.sayyoung.ui.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.Constants;
import com.yw.sayyoung.sayyoung.base.activity.BaseActivity;
import com.yw.sayyoung.sayyoung.contract.MainContract;
import com.yw.sayyoung.sayyoung.presenter.MainPresenter;
import com.yw.sayyoung.sayyoung.ui.fragment.MainPagerFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    @BindView(R.id.main_floating_action_btn)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.fragment_group)

    TextView textView;
    private ArrayList<Fragment> mFragments;
    private Fragment mMainPagerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments = new ArrayList<>();
        if (savedInstanceState == null) {
            mPresenter.setNightModeState(false);
            mMainPagerFragment = MainPagerFragment.getInstance(false, null);
            mFragments.add(mMainPagerFragment);
            initData();
            init();
            switchFragment(Constants.TYPE_MAIN_PAGER);
        } else {
            mBottomNavigationView.setSelectedItemId(R.id.tab_main_pager);
            mMainPagerFragment = MainPagerFragment.getInstance(true, null);
            mFragments.add(mMainPagerFragment);
            initData();
            init();
            switchFragment(Constants.TYPE_SETTING);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showBranner() {

    }

    @Override
    public void showGoods() {

    }
}
