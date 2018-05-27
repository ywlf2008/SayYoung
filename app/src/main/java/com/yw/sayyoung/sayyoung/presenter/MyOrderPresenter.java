package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.contract.MyOrderContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

import javax.inject.Inject;

public class MyOrderPresenter extends BasePresenter<MyOrderContract.View> implements MyOrderContract.Presenter {

    DataManager mDataManager;

    @Inject
    public MyOrderPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

}
