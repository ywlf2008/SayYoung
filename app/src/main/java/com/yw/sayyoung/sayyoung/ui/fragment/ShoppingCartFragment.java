package com.yw.sayyoung.sayyoung.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.ContentFragmentContract;
import com.yw.sayyoung.sayyoung.contract.ShoppingCartContract;
import com.yw.sayyoung.sayyoung.core.bean.Goods;
import com.yw.sayyoung.sayyoung.presenter.ContentPresenter;
import com.yw.sayyoung.sayyoung.presenter.ShoppingCartPresenter;
import com.yw.sayyoung.sayyoung.ui.adapter.ShoppingCartAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShoppingCartFragment extends AbstractRootFragment<ShoppingCartPresenter> implements ShoppingCartContract.View {

    @BindView(R.id.shopping_cart_recycler_view)
    RecyclerView mRecyclerView;
    ShoppingCartAdapter mAdapter;
    List<Goods> mData;

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
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.getShoppingList();
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
    }
}
