package com.yw.sayyoung.sayyoung.ui.fragment;

import android.os.Bundle;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.OrderPayContract;
import com.yw.sayyoung.sayyoung.presenter.OrderPayPresenter;
import com.yw.sayyoung.sayyoung.ui.activity.ShoppingCartActivity;

public class OrderPayFragment extends AbstractRootFragment<OrderPayPresenter> implements OrderPayContract.View {

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
//        isInnerFragment = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ShoppingCartActivity) _mActivity).setToolbarTitle("订单支付");
    }

    public static OrderPayFragment newInstance() {
        Bundle args = new Bundle();

        OrderPayFragment fragment = new OrderPayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_pay;
    }
}
