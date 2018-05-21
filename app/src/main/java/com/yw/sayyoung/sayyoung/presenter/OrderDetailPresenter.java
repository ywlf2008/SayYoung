package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.OrderDetailContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

import javax.inject.Inject;

public class OrderDetailPresenter extends BasePresenter<OrderDetailContract.View> implements OrderDetailContract.Presenter {
    DataManager mDataManager;

    @Inject
    public OrderDetailPresenter(DataManager dataManager) {
        super(dataManager);
    }

}
