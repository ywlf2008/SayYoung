package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.OrderDetailContract;
import com.yw.sayyoung.sayyoung.contract.OrderPayContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

import javax.inject.Inject;

public class OrderPayPresenter extends BasePresenter<OrderPayContract.View> implements OrderPayContract.Presenter{
    DataManager mDataManager;

    @Inject
    public OrderPayPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
