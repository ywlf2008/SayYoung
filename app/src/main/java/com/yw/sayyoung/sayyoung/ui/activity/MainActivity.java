package com.yw.sayyoung.sayyoung.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.Constants;
import com.yw.sayyoung.sayyoung.base.activity.BaseActivity;
import com.yw.sayyoung.sayyoung.contract.MainContract;
import com.yw.sayyoung.sayyoung.core.bean.Goods;
import com.yw.sayyoung.sayyoung.presenter.MainPresenter;
import com.yw.sayyoung.sayyoung.ui.fragment.ContentFragment;
import com.yw.sayyoung.sayyoung.ui.fragment.MainPagerFragment;
import com.yw.sayyoung.sayyoung.ui.fragment.ShoppingCartFragment;
import com.yw.sayyoung.sayyoung.utils.BottomNavigationViewHelper;
import com.yw.sayyoung.sayyoung.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

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
    FrameLayout mFrameGroup;

    private ArrayList<Fragment> mFragments;
    private MainPagerFragment mMainPagerFragment;
    private ShoppingCartFragment mShoppingCartFragment;
    private ContentFragment mSpreadFragment;
    private ContentFragment mMineFragment;
    private int mLastFgIndex;
    private TextView mUsTv;
    private int mGoIndex = 0;

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
    protected void initEventAndData() {
        initToolbar();
    }

    private void switchFragment(int position) {
        if (position >= Constants.TYPE_COLLECT) {
            mFloatingActionButton.setVisibility(View.INVISIBLE);
            mBottomNavigationView.setVisibility(View.INVISIBLE);
        } else {
            mFloatingActionButton.setVisibility(View.VISIBLE);
            mBottomNavigationView.setVisibility(View.VISIBLE);
        }
        if (position >= mFragments.size()) {
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment targetFg = mFragments.get(position);
        Fragment lastFg = mFragments.get(mLastFgIndex);
        mLastFgIndex = position;
        ft.hide(lastFg);
        if (!targetFg.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(targetFg).commit();
            ft.add(R.id.fragment_group, targetFg);
        }
        ft.show(targetFg);
        ft.commitAllowingStateLoss();
    }

    private void init() {
        initNavigationView();
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            boolean isGoLogin = false;
            switch (item.getItemId()) {
                case R.id.tab_main_pager:
                    mTitleTv.setText(getString(R.string.home_pager));
                    switchFragment(0);
                    mMainPagerFragment.reload();
                    mPresenter.setCurrentPage(Constants.TYPE_MAIN_PAGER);
                    break;
                case R.id.tab_knowledge_hierarchy:
                    mGoIndex = 1;
                    if (isLogin()) {
                        mTitleTv.setText(getString(R.string.shopping_cart));
                        switchFragment(1);
                    } else {
                        isGoLogin = true;
                    }
                    break;
                case R.id.tab_navigation:
                    mGoIndex = 2;
                    if (isLogin()) {
                        mTitleTv.setText(getString(R.string.spread));
                        switchFragment(2);
                    } else {
                        isGoLogin = true;
                    }
                    break;
                case R.id.tab_project:
                    mGoIndex = 3;
                    if (isLogin()) {
                        mTitleTv.setText(getString(R.string.mine));
                        switchFragment(3);
                    } else {
                        isGoLogin = true;
                    }
                    break;
                default:
                    break;
            }
            if (isGoLogin) {
                startActivityForResult(new Intent(MainActivity.this, Login1Activity.class), Constants.REQUEST_LOGIN);
                return false;
            }
            return true;
        });
    }

    private void clickIndex(int index) {
        switch (index) {
            case 0:
                mBottomNavigationView.setSelectedItemId(R.id.tab_main_pager);
                break;
            case 1:
                mBottomNavigationView.setSelectedItemId(R.id.tab_knowledge_hierarchy);
                break;
            case 2:
                mBottomNavigationView.setSelectedItemId(R.id.tab_navigation);
                break;
            case 3:
                mBottomNavigationView.setSelectedItemId(R.id.tab_project);
                break;
            default:
                break;
        }

    }

    private void initNavigationView() {
        mUsTv = mNavigationView.getHeaderView(0).findViewById(R.id.nav_header_login_tv);
        if (mPresenter.getLoginStatus()) {
            showLoginView();
        } else {
            showLogoutView();
        }

        mNavigationView.getMenu().findItem(R.id.nav_item_wan_android)
                .setOnMenuItemClickListener(item -> {
//                    startMainPager();
                    return true;
                });
        mNavigationView.getMenu().findItem(R.id.nav_item_my_collect)
                .setOnMenuItemClickListener(item -> {
//                    if (mPresenter.getLoginStatus()) {
//                        startCollectFragment();
//                        return true;
//                    } else {
//                        startActivity(new Intent(this, LoginActivity.class));
//                        CommonUtils.showMessage(this, getString(R.string.login_tint));
//                        return true;
//                    }
                    return true;
                });
        mNavigationView.getMenu().findItem(R.id.nav_item_about_us)
                .setOnMenuItemClickListener(item -> {
//                    startActivity(new Intent(this, AboutUsActivity.class));
                    return true;
                });
        mNavigationView.getMenu().findItem(R.id.nav_item_logout)
                .setOnMenuItemClickListener(item -> {
                    logout();
                    return true;
                });
        mNavigationView.getMenu().findItem(R.id.nav_item_setting)
                .setOnMenuItemClickListener(item -> {
//                    startSettingFragment();
                    return true;
                });
    }

    private void logout() {
        mPresenter.logout();
    }

    private void initData() {
        mShoppingCartFragment = new ShoppingCartFragment();
        mSpreadFragment = new ContentFragment();
        mMineFragment = new ContentFragment();

        mFragments.add(mShoppingCartFragment);
        mFragments.add(mSpreadFragment);
        mFragments.add(mMineFragment);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        mTitleTv.setText(getString(R.string.home_pager));
        StatusBarUtil.setStatusColor(getWindow(), ContextCompat.getColor(this, R.color.black_90), 1f);
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    private void jumpToTheTop() {
        switch (mPresenter.getCurrentPage()) {
            case Constants.TYPE_MAIN_PAGER:
                if (mMainPagerFragment != null) {
                    mMainPagerFragment.jumpToTheTop();
                }
                break;
            case Constants.TYPE_KNOWLEDGE:
                if (mShoppingCartFragment != null) {
                    mShoppingCartFragment.jumpToTheTop();
                }
                break;
            case Constants.TYPE_NAVIGATION:
                if (mSpreadFragment != null) {
                    mSpreadFragment.jumpToTheTop();
                }
                break;
            case Constants.TYPE_PROJECT:
                if (mMainPagerFragment != null) {
                    mMainPagerFragment.jumpToTheTop();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showBanner() {

    }

    @Override
    public void showGoods() {

    }

    private boolean isLogin() {
        return mPresenter.isLogin();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_LOGIN && resultCode == Constants.RESULT_LOGIN) {
            if (data != null && data.getBooleanExtra(Constants.EXTRA_LOGIN, false)) {
                clickIndex(mGoIndex);
            }
        }
    }
}
