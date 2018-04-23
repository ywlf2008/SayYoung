package com.yw.sayyoung.sayyoung.contract;

import com.yw.sayyoung.sayyoung.base.presenter.AbstractPresenter;
import com.yw.sayyoung.sayyoung.base.view.BaseView;

public class MainPagerContract {

    public interface View extends BaseView {

        /**
         * Show switch project
         */
        void showBranner();

        /**
         * Show switch navigation
         */
        void showGoods();
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
    }

}
