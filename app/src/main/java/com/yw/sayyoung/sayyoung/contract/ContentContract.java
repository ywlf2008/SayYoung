package com.yw.sayyoung.sayyoung.contract;

import com.yw.sayyoung.sayyoung.base.presenter.AbstractPresenter;
import com.yw.sayyoung.sayyoung.base.view.BaseView;

public class ContentContract {

    public interface View extends BaseView {

    }

    public interface Presenter extends AbstractPresenter<ContentContract.View> {

    }
}
