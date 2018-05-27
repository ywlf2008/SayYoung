package com.yw.sayyoung.sayyoung.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.Constants;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.core.bean.Goods;
import com.yw.sayyoung.sayyoung.presenter.MainPagerPresenter;
import com.yw.sayyoung.sayyoung.ui.activity.GoodsDetailActivity;
import com.yw.sayyoung.sayyoung.ui.adapter.GoodsAdapter;
import com.yw.sayyoung.sayyoung.utils.GlideImageLoader;
import com.yw.sayyoung.sayyoung.widget.GridDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnItemClick;

public class MainPagerFragment extends AbstractRootFragment<MainPagerPresenter> implements MainPagerContract.View {

    private static final String TAG = MainPagerFragment.class.getSimpleName();
    public static final int REQUEST_TYPE_REFRESH = 0;
    public static final int REQUEST_TYPE_LOADMORE = 1;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.main_pager_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.normal_view)
    SmartRefreshLayout mSmartRefreshLayout;
    private List<String> images;
    private GoodsAdapter mAdapter;
    private List<Goods> mData;
    private int mRequestType;
    private int mCurrentPage = 0;

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
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186188896&di=dafb9ec2a4f1b4fdc97af5570911390e&imgtype=0&src=http%3A%2F%2Fimg.91jm.com%2F2017%2F02%2F91yw747Zfajm.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186429483&di=db887385184542c3672e4b01fda6023e&imgtype=0&src=http%3A%2F%2Fpic64.nipic.com%2Ffile%2F20150418%2F11653002_135640782461_2.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186501896&di=09c2123abbb1e20cf4439e4be9f4eea0&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F19%2F58%2F81%2F24q58PICuSt_1024.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186519838&di=7ab3fa7413c8f780a5e892d6421ffbc5&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F50%2F37%2F65S58PICuX8_1024.jpg");
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186560380&di=f5df8ecef3563f4e067ef40785525296&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F16%2F76%2F88%2F91N58PICc5P_1024.jpg");
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.addItemDecoration(new GridDividerItemDecoration(25, 0x00ffffff));
        mData = new ArrayList<>();
        mAdapter = new GoodsAdapter(mData);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Goods goods = mData.get(position);
                switch (view.getId()) {
                    case R.id.iv_shopping:
                        Toast.makeText(_mActivity, "加入购物车", Toast.LENGTH_SHORT).show();
                        mPresenter.putCart(goods);
                        break;
                    case R.id.iv_image:
                        Intent intent = new Intent(getActivity(), GoodsDetailActivity.class);
                        intent.putExtra("goods", goods);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }

            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setEnableLoadMore(false);
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
        mSmartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                Log.e(TAG, "onRefresh");
                mRequestType = REQUEST_TYPE_REFRESH;
                mCurrentPage = 0;
                mSmartRefreshLayout.setNoMoreData(false);
                mPresenter.setCurrentPage(mCurrentPage);
            }

            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                Log.e(TAG, "onLoadMore");
                mRequestType = REQUEST_TYPE_LOADMORE;
                mCurrentPage++;
                mPresenter.setCurrentPage(mCurrentPage);
//                mSmartRefreshLayout.finishLoadMore(true);
            }
        });
        mPresenter.setCurrentPage(0);
    }

    @Override
    public void showBanner() {

    }

    @Override
    public void showGoods(List<Goods> list) {
        if (mRequestType == REQUEST_TYPE_REFRESH) {
            mData.clear();
            mSmartRefreshLayout.finishRefresh(true);
        } else {
            if (list != null && list.size() > 0) {
                mData.addAll(list);
                mSmartRefreshLayout.finishLoadMore(true);
            } else {
                mSmartRefreshLayout.finishLoadMoreWithNoMoreData();
            }
        }
        if (list != null) {
            mData.addAll(list);
        }
        mAdapter.notifyDataSetChanged();
    }

    public void jumpToTheTop() {
        if (mRecyclerView != null) {
            mRecyclerView.smoothScrollToPosition(0);
        }
    }
}
