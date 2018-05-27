package com.yw.sayyoung.sayyoung.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bumptech.glide.Glide;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.MyOrderContract;
import com.yw.sayyoung.sayyoung.presenter.MyOrderPresenter;
import com.yw.sayyoung.sayyoung.ui.adapter.OrderPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyOrderFragment extends AbstractRootFragment<MyOrderPresenter> implements MyOrderContract.View {

    private String[] TAB_ITEMS= {"待支付","待发货","全部订单"};
    @BindView(R.id.profile_image)
    CircleImageView mCircleImageView;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    List<Fragment> mFragmentList;
    OrderPageAdapter mAdapter;

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186188896&di=dafb9ec2a4f1b4fdc97af5570911390e&imgtype=0&src=http%3A%2F%2Fimg.91jm.com%2F2017%2F02%2F91yw747Zfajm.jpg").into(mCircleImageView);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new TextFragment());
        mFragmentList.add(new TextFragment());
        mFragmentList.add(new TextFragment());
        mAdapter = new OrderPageAdapter(getChildFragmentManager(), mFragmentList,TAB_ITEMS);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_mine;
    }

    public void jumpToTheTop() {

    }

}
