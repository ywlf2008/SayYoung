package com.yw.sayyoung.sayyoung.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.OrderDetailContract;
import com.yw.sayyoung.sayyoung.core.bean.Goods;
import com.yw.sayyoung.sayyoung.presenter.OrderDetailPresenter;
import com.yw.sayyoung.sayyoung.ui.activity.ShoppingCartActivity;
import com.yw.sayyoung.sayyoung.ui.adapter.OrderDetailAdapter;
import com.yw.sayyoung.sayyoung.ui.adapter.ShoppingCartAdapter;
import com.yw.sayyoung.sayyoung.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderDetailFragment extends AbstractRootFragment<OrderDetailPresenter> implements OrderDetailContract.View {

    private static final String TAG = OrderDetailFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_price_total)
    TextView tvPriceTotal;
    @BindView(R.id.tv_count_total)
    TextView tvCountTotal;
    OrderDetailAdapter mAdapter;
    List<Goods> mData;

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        mData = new ArrayList<>();
        mAdapter = new OrderDetailAdapter(mData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 5, 0x00ffffff));
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.getShoppingList();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_detail;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ShoppingCartActivity) _mActivity).setToolbarTitle("订单详情");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            ((ShoppingCartActivity) _mActivity).setToolbarTitle("订单详情");
        }
    }

    public static OrderDetailFragment newInstance() {

        Bundle args = new Bundle();

        OrderDetailFragment fragment = new OrderDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.tv_submit)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                start(OrderPayFragment.newInstance());
                break;
            default:
                break;
        }
    }

    @Override
    public void showData(List<Goods> list) {
        Log.e(TAG, "list size " + list.size());
        mData.clear();
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
        float priceTotal = 0;
        int countTotal = 0;
        for (Goods goods : mData) {
            priceTotal += goods.getPrice() * goods.getCount();
            countTotal += goods.getCount();
        }
        tvPriceTotal.setText(String.valueOf(priceTotal));
        tvCountTotal.setText(getString(R.string.total_count, String.valueOf(countTotal)));
    }

}
