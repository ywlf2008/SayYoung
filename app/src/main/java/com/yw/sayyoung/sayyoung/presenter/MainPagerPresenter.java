package com.yw.sayyoung.sayyoung.presenter;

import com.yw.sayyoung.sayyoung.base.presenter.BasePresenter;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.core.DataManager;
import com.yw.sayyoung.sayyoung.core.bean.Goods;

import java.util.ArrayList;
import java.util.List;

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
        String num = "";
        List<Goods> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (index > 0 && index < 10) {
                num = "00" + index;
            } else if (index > 10) {
                num = "0" + index;
            } else if (index > 34) {
                index = 0;
            }
            Goods goods = new Goods("https://img.onvshen.com:85/gallery/22494/18924/" + num + ".jpg", "美女" + (i + 1), 100 + i);
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
