package com.yw.sayyoung.sayyoung.ui.fragment;

import com.bumptech.glide.Glide;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.base.fragment.AbstractRootFragment;
import com.yw.sayyoung.sayyoung.contract.MineContract;
import com.yw.sayyoung.sayyoung.presenter.MinePresenter;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MineFragment extends AbstractRootFragment<MinePresenter> implements MineContract.View {
    @BindView(R.id.profile_image)
    CircleImageView mCircleImageView;

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527186188896&di=dafb9ec2a4f1b4fdc97af5570911390e&imgtype=0&src=http%3A%2F%2Fimg.91jm.com%2F2017%2F02%2F91yw747Zfajm.jpg").into(mCircleImageView);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
