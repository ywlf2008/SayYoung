package com.yw.sayyoung.sayyoung.contract;

import com.yw.sayyoung.sayyoung.base.presenter.AbstractPresenter;
import com.yw.sayyoung.sayyoung.base.view.BaseView;
import com.yw.sayyoung.sayyoung.core.bean.Goods;

import java.util.List;

public class MainPagerContract {

    public interface View extends BaseView {

        /**
         * Show switch project
         */
        void showBanner();

        /**
         * Show switch navigation
         */
        void showGoods(List<Goods> list);
    }

    public interface Presenter extends AbstractPresenter<MainPagerContract.View> {

        /**
         * Set current page
         *
         * @param page current page
         */
        void setCurrentPage(int page);

        /**
         * Set night mode state
         *
         * @param b current night mode state
         */
        void setNightModeState(boolean b);

        void putCart(Goods goods);

    }

}
