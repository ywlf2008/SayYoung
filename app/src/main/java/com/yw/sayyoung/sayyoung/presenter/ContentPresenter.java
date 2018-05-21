package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.ContentContract;
import com.yw.sayyoung.sayyoung.contract.ContentFragmentContract;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

import javax.inject.Inject;

public class ContentPresenter extends BasePresenter<ContentContract.View> implements ContentContract.Presenter{

    DataManager mDataManager;

    @Inject
    public ContentPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

}
