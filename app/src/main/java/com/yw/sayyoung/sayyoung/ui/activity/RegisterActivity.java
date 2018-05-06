package com.yw.sayyoung.sayyoung.ui.activity;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.activity.BaseActivity;
import com.yw.sayyoung.sayyoung.contract.RegisterContract;
import com.yw.sayyoung.sayyoung.presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View{

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInject() {

    }
}
