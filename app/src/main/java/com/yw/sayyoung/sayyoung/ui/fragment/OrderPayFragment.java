package com.yw.sayyoung.sayyoung.ui.fragment;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.OrderPayContract;
import com.yw.sayyoung.sayyoung.presenter.OrderPayPresenter;

public class OrderPayFragment extends AbstractRootFragment<OrderPayPresenter> implements OrderPayContract.View {

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
//        isInnerFragment = true;
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
