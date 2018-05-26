package com.yw.sayyoung.sayyoung.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.SayYoungApp;
import com.yw.sayyoung.sayyoung.core.bean.Goods;

import java.util.List;

public class OrderDetailAdapter extends BaseQuickAdapter<Goods, BaseViewHolder> {
    public OrderDetailAdapter(@Nullable List<Goods> data) {
        super(R.layout.item_order_detail_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Goods item) {
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_price, String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_count, String.valueOf(item.getCount()));
        Glide.with(SayYoungApp.getInstance()).load(item.getImgUrl()).into((ImageView) helper.getView(R.id.iv_image));

    }
}
