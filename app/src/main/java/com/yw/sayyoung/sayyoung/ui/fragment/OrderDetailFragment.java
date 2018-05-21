package com.yw.sayyoung.sayyoung.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.OrderDetailContract;
import com.yw.sayyoung.sayyoung.presenter.OrderDetailPresenter;

import butterknife.OnClick;

public class OrderDetailFragment extends AbstractRootFragment<OrderDetailPresenter> implements OrderDetailContract.View{

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        isInnerFragment = true;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_detail;
    }

    public static OrderDetailFragment newInstance() {

        Bundle args = new Bundle();

        OrderDetailFragment fragment = new OrderDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.tv_submit)
    public  void onClick(View view){
        switch(view.getId()){
            case R.id.tv_submit:
                start(OrderDetailFragment.newInstance());
                break;
            default:
                break;
        }
    }

}
