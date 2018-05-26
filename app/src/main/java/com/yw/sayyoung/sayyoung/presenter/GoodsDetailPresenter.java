package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.GoodsDetailContract;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

import javax.inject.Inject;

public class GoodsDetailPresenter extends BasePresenter<GoodsDetailContract.View> implements GoodsDetailContract.Presenter {
    DataManager mDataManager;

    @Inject
    public GoodsDetailPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }
}
