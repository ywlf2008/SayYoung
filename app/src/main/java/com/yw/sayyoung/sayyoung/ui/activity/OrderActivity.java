package com.yw.sayyoung.sayyoung.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.activity.BaseActivity;
import com.yw.sayyoung.sayyoung.contract.ContentContract;
import com.yw.sayyoung.sayyoung.presenter.ContentPresenter;
import com.yw.sayyoung.sayyoung.ui.fragment.OrderDetailFragment;
import com.yw.sayyoung.sayyoung.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderActivity extends BaseActivity<ContentPresenter> implements ContentContract.View {

    public static final String STACK_NAME = "stack_fragment";
    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    List<Fragment> mFragmentList;
    FragmentManager mFragmentManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment_content;
    }

    @Override
    protected void initEventAndData() {
        mFragmentList = new ArrayList<>();
        mFragmentManager = getSupportFragmentManager();
        showFragment(OrderDetailFragment.newInstance());
        initToolbar();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    private void showFragment(Fragment fragment) {
        mFragmentManager.beginTransaction()
                .replace(R.id.content_fragment, fragment)
                .addToBackStack(STACK_NAME)
                .commitAllowingStateLoss();
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


}
