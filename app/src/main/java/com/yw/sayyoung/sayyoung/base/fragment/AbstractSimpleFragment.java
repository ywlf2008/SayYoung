package com.yw.sayyoung.sayyoung.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.leakcanary.RefWatcher;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.SayYoungApp;
import com.yw.sayyoung.sayyoung.utils.CommonUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Common simple fragment
 *
 * @author quchao
 * @date 2017/11/28
 */

public abstract class AbstractSimpleFragment extends SupportFragment {

    private Unbinder unBinder;
    private long clickTime;
    private CompositeDisposable mCompositeDisposable;
    public boolean isInnerFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, view);
        mCompositeDisposable = new CompositeDisposable();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
        unBinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //LeakCanary
        RefWatcher refWatcher = SayYoungApp.getRefWatcher(_mActivity);
        refWatcher.watch(this);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEventAndData();
    }

    /**
     * 处理回退事件
     */
    @Override
    public boolean onBackPressedSupport() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
            if (isInnerFragment) {
                _mActivity.finish();
                return true;
            }
//            long currentTime = System.currentTimeMillis();
//            long time = 2000;
//            if ((currentTime - clickTime) > time) {
//                CommonUtils.showSnackMessage(_mActivity, getString(R.string.double_click_exit_tint));
//                clickTime = System.currentTimeMillis();
//            } else {
//                _mActivity.finish();
//            }
            if(getFragmentManager().getBackStackEntryCount()<=1){
                _mActivity.finish();
                return true;
            }
            pop();
        }
        return true;
    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();

}
