package com.yw.sayyoung.sayyoung.contract;

import com.yw.sayyoung.sayyoung.base.presenter.AbstractPresenter;
import com.yw.sayyoung.sayyoung.base.view.BaseView;
import com.yw.sayyoung.sayyoung.core.bean.Goods;

import java.util.List;

public class ShoppingCartContract {

    public interface View extends BaseView {

        void ShoppingCart(List<Goods> list);

    }

    public interface Presenter extends AbstractPresenter<ShoppingCartContract.View> {
        void getShoppingList();
    }
}
