package com.yw.sayyoung.sayyoung.ui.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.SayYoungApp;
import com.yw.sayyoung.sayyoung.base.activity.BaseActivity;
import com.yw.sayyoung.sayyoung.contract.GoodsDetailContract;
import com.yw.sayyoung.sayyoung.core.bean.Goods;
import com.yw.sayyoung.sayyoung.presenter.GoodsDetailPresenter;
import com.yw.sayyoung.sayyoung.utils.StatusBarUtil;

import butterknife.BindView;

public class GoodsDetailActivity extends BaseActivity<GoodsDetailPresenter> implements GoodsDetailContract.View {

    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    @BindView(R.id.iv_content)
    ImageView mIvContent;
    Goods mGoods;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void initEventAndData() {
        initToolbar();
        mGoods = getIntent().getParcelableExtra("goods");
        Glide.with(SayYoungApp.getInstance()).load(mGoods.getImgUrl()).into(mIvContent);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        mTitleTv.setText(getString(R.string.order_detail));
        StatusBarUtil.setStatusColor(getWindow(), ContextCompat.getColor(this, R.color.black_90), 1f);
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }
}
