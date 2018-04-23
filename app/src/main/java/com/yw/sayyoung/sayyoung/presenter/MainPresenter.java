package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.MainContract;
import com.yw.sayyoung.sayyoung.core.DataManager;
import com.yw.sayyoung.sayyoung.core.bean.Goods;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void setCurrentPage(int page) {

    }

    @Override
    public void setNightModeState(boolean b) {

    }
}
