package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.app.Constants;
import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.core.DataManager;
import com.yw.sayyoung.sayyoung.core.bean.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

public class MainPagerPresenter extends BasePresenter<MainPagerContract.View> implements MainPagerContract.Presenter {

    DataManager mDataManager;
    int index = 0;

    @Inject
    public MainPagerPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void setCurrentPage(int page) {
        List<Goods> list = getList();
        mView.showGoods(list);
    }

    private List<Goods> getList() {
        Random random = new Random();
        List<Goods> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Goods goods = new Goods(Constants.IMAGE_URLS[random.nextInt(Constants.IMAGE_URLS.length)], "商品" + (i + 1), (random.nextInt(10) * 100 + random.nextInt(10)));
            index++;
            list.add(goods);
        }
        return list;
    }

    @Override
    public void setNightModeState(boolean b) {

    }

    @Override
    public void putCart(Goods goods) {
        List<Goods> list = mDataManager.getShoppingList();
        if (!list.contains(goods)) {
            list.add(goods);
        }
    }

}
