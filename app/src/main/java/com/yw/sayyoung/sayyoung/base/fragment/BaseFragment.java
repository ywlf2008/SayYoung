package com.yw.sayyoung.sayyoung.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.SayYoungApp;
import com.yw.sayyoung.sayyoung.base.presenter.AbstractPresenter;
import com.yw.sayyoung.sayyoung.base.view.BaseView;
import com.yw.sayyoung.sayyoung.di.component.DaggerFragmentComponent;
import com.yw.sayyoung.sayyoung.di.component.FragmentComponent;
import com.yw.sayyoung.sayyoung.di.module.FragmentModule;
import com.yw.sayyoung.sayyoung.utils.CommonUtils;

import javax.inject.Inject;

/**
 * MVP模式的Base fragment
 *
 * @author quchao
 * @date 2017/11/28
 */

public abstract class BaseFragment<T extends AbstractPresenter> extends AbstractSimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(SayYoungApp.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void useNightMode(boolean isNightMode) {
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        if (isAdded()) {
            CommonUtils.showSnackMessage(_mActivity, errorMsg);
        }
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void showCollectFail() {
        CommonUtils.showSnackMessage(_mActivity, getString(R.string.collect_fail));
    }

    @Override
    public void showCancelCollectFail() {
        CommonUtils.showSnackMessage(_mActivity, getString(R.string.cancel_collect_fail));
    }

    @Override
    public void showCollectSuccess() {

    }

    @Override
    public void showCancelCollectSuccess() {

    }

    @Override
    public void showLoginView() {

    }

    @Override
    public void showLogoutView() {

    }

    /**
     * 注入当前Fragment所需的依赖
     */
    protected abstract void initInject();

}
