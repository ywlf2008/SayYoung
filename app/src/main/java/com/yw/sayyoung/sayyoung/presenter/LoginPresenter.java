package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.LoginContract;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter{
    DataManager mDataManager;
    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
