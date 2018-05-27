package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.MainContract;
import com.yw.sayyoung.sayyoung.contract.MineContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

import javax.inject.Inject;

public class MinePresenter extends BasePresenter<MineContract.View> implements MineContract.Presenter {

    DataManager mDataManager;

    @Inject
    public MinePresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }
}
