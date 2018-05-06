package com.yw.sayyoung.sayyoung.ui.fragment;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.ContentFragmentContract;
import com.yw.sayyoung.sayyoung.presenter.ContentPresenter;

public class ContentFragment extends AbstractRootFragment<ContentPresenter> implements ContentFragmentContract.View{
    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
    }

    public void jumpToTheTop() {

    }
}
