package com.yw.sayyoung.sayyoung.contract;

import com.yw.sayyoung.sayyoung.base.presenter.AbstractPresenter;
import com.yw.sayyoung.sayyoung.base.view.BaseView;

public class ContentFragmentContract {

    public interface View extends BaseView {

    }

    public interface Presenter extends AbstractPresenter<ContentFragmentContract.View> {

    }
}
