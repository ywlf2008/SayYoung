package com.yw.sayyoung.sayyoung.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.Constants;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.core.bean.Goods;
import com.yw.sayyoung.sayyoung.presenter.MainPagerPresenter;
import com.yw.sayyoung.sayyoung.ui.adapter.GoodsAdapter;
import com.yw.sayyoung.sayyoung.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;

public class MainPagerFragment extends AbstractRootFragment<MainPagerPresenter> implements MainPagerContract.View {

    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.main_pager_recycler_view)
    RecyclerView mRecyclerView;
    private List<String> images;
    private GoodsAdapter mAdapter;
    private List<Goods> mData;

    public static MainPagerFragment getInstance(boolean param1, String param2) {
        MainPagerFragment fragment = new MainPagerFragment();
        Bundle args = new Bundle();
        args.putBoolean(Constants.ARG_PARAM1, param1);
        args.putString(Constants.ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        images = new ArrayList<>();
        images.add("http://www.ftoow.com/attachment/Mon_1711/15_2_9e57f2c388ffdb5.jpg?41");
        images.add("http://www.ftoow.com/attachment/Mon_1711/15_2_8ef47d7cba56fe1.jpg?41");
        images.add("http://img.yeitu.com/2017/1123/20171123094451619.jpg?imageslim");
        images.add("http://img.yeitu.com/2017/1123/20171123094450423.jpg?imageslim");
        images.add("http://img.yeitu.com/2017/1123/20171123094450200.jpg?imageslim");
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mData = new ArrayList<>();
        mAdapter = new GoodsAdapter(mData);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Goods goods = mData.get(position);
                mPresenter.putCart(goods);
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.setCurrentPage(0);
    }

    @Override
    public void showBanner() {

    }

    @Override
    public void showGoods(List<Goods> list) {
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    public void jumpToTheTop() {
        if (mRecyclerView != null) {
            mRecyclerView.smoothScrollToPosition(0);
        }
    }
}
