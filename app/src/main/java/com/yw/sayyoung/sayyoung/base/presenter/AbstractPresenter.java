package com.yw.sayyoung.sayyoung.base.presenter;

import com.yw.sayyoung.sayyoung.base.view.BaseView;

import io.reactivex.disposables.Disposable;

/**
 * Presenter 基类
 *
 * @author quchao
 * @date 2017/11/27
 */

public interface AbstractPresenter<T extends BaseView> {

    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

    /**
     * Add rxBing subscribe manager
     *
     * @param disposable Disposable
     */
    void addRxBindingSubscribe(Disposable disposable);

    /**
     * Get night mode state
     *
     * @return if is night mode
     */
    boolean getNightModeState();

    /**
     * Set login status
     *
     * @param loginStatus login status
     */
    void setLoginStatus(boolean loginStatus);

    /**
     * Get login status
     *
     * @return if is login status
     */
    boolean getLoginStatus();

    /**
     * Get login account
     *
     * @return login account
     */
    String getLoginAccount();

    /**
     * Set login account
     *
     * @param account
     */
    void setLoginAccount(String account);

    /**
     * Get current page
     *
     * @return current page
     */
    int getCurrentPage();


}
