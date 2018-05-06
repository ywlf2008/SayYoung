package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.ContentFragmentContract;
import com.yw.sayyoung.sayyoung.contract.ShoppingCartContract;
import com.yw.sayyoung.sayyoung.core.DataManager;
import com.yw.sayyoung.sayyoung.core.bean.Goods;

import java.util.List;

import javax.inject.Inject;

public class ShoppingCartPresenter extends BasePresenter<ShoppingCartContract.View> implements ShoppingCartContract.Presenter{

    DataManager mDataManager;

    @Inject
    public ShoppingCartPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void getShoppingList() {
        mView.ShoppingCart(mDataManager.getShoppingList());
    }
}
