package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.RegisterContract;
import com.yw.sayyoung.sayyoung.core.DataManager;

public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter{

    public RegisterPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
