package com.yw.sayyoung.sayyoung.contract;

import com.yw.sayyoung.sayyoung.base.presenter.AbstractPresenter;
import com.yw.sayyoung.sayyoung.base.view.BaseView;
import com.yw.sayyoung.sayyoung.core.bean.Goods;

import java.util.List;

public class OrderDetailContract {

    public interface View extends BaseView {

    }

    public interface Presenter extends AbstractPresenter<OrderDetailContract.View> {

    }

}
