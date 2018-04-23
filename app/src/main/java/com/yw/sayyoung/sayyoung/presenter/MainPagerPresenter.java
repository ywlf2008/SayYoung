package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

import javax.inject.Inject;

public class MainPagerPresenter extends BasePresenter<MainPagerContract.View> implements MainPagerContract.Presenter {

    DataManager mDataManager;

    @Inject
    public MainPagerPresenter(DataManager dataManager) {
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
