package com.yw.sayyoung.sayyoung.ui.fragment;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.MainPagerContract;
import com.yw.sayyoung.sayyoung.presenter.MainPagerPresenter;

public class MainPagerFragment extends AbstractRootFragment<MainPagerPresenter> implements MainPagerContract.View{
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
    }

    @Override
    public void showBranner() {

    }

    @Override
    public void showGoods() {

    }
}
