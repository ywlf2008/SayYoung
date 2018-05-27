package com.yw.sayyoung.sayyoung.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.ShoppingCartContract;
import com.yw.sayyoung.sayyoung.core.bean.Goods;
import com.yw.sayyoung.sayyoung.presenter.ShoppingCartPresenter;
import com.yw.sayyoung.sayyoung.ui.activity.ShoppingCartActivity;
import com.yw.sayyoung.sayyoung.ui.adapter.ShoppingCartAdapter;
import com.yw.sayyoung.sayyoung.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ShoppingCartFragment extends AbstractRootFragment<ShoppingCartPresenter> implements ShoppingCartContract.View {

    private static final String TAG = ShoppingCartFragment.class.getSimpleName();
    @BindView(R.id.shopping_cart_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.normal_view)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.tv_settle)
    TextView tvSettle;
    @BindView(R.id.tv_price_total)
    TextView tvPriceTotal;
    @BindView(R.id.tv_count_total)
    TextView tvCountTotal;
    ShoppingCartAdapter mAdapter;
    List<Goods> mData;
    float mPriceTotal = 0;
    int mCountTotal = 0;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shopping_cart;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        mData = new ArrayList<>();
        mAdapter = new ShoppingCartAdapter(mData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 10, 0x00ffffff));
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.getShoppingList();
        mAdapter.setCountChangeListener(new ShoppingCartAdapter.ICountChangeListener() {
            @Override
            public void onCountChange(Goods goods, int count) {
                mPriceTotal += goods.getPrice() * count;
                mCountTotal += count;
                setTotal();
            }
        });
        mSmartRefreshLayout.setEnableRefresh(false);
        mSmartRefreshLayout.setEnableLoadMore(false);
        mAdapter.setEnableLoadMore(false);
        mAdapter.setUpFetchEnable(false);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            if (mData != null) {
                mPresenter.getShoppingList();
            }
        }
    }

    public void jumpToTheTop() {

    }

    @Override
    public void ShoppingCart(List<Goods> list) {
        mData.clear();
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
        mPriceTotal = 0;
        mCountTotal = 0;
        for (Goods goods : mData) {
            mPriceTotal += goods.getPrice() * goods.getCount();
            mCountTotal += goods.getCount();
        }
        setTotal();
    }

    @OnClick(R.id.tv_settle)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_settle:
                startActivity(new Intent(getActivity(), ShoppingCartActivity.class));
                break;
            default:
                break;
        }
    }

    private void setTotal() {
        tvPriceTotal.setText(String.valueOf(mPriceTotal));
        tvCountTotal.setText(getString(R.string.total_count, String.valueOf(mCountTotal)));
    }

}
