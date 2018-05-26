package com.yw.sayyoung.sayyoung.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.SayYoungApp;
import com.yw.sayyoung.sayyoung.core.bean.Goods;
import com.yw.sayyoung.sayyoung.widget.CountChangeView;

import java.util.List;

public class ShoppingCartAdapter extends BaseQuickAdapter<Goods, BaseViewHolder> {

    private ICountChangeListener mListener;

    public ShoppingCartAdapter(@Nullable List<Goods> data) {
        super(R.layout.item_shopping_cart_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Goods item) {
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_price, String.valueOf(item.getPrice()));
        Glide.with(SayYoungApp.getInstance()).load(item.getImgUrl()).into((ImageView) helper.getView(R.id.iv_image));
        ((CountChangeView) helper.getView(R.id.cv_count_change)).setCountChangeListener(new CountChangeView.ICountChangeListener() {
            @Override
            public void onCountChange(int count) {
                if (mListener != null) {
                    mListener.onCountChange(item, count - item.getCount());
                }
                item.setCount(count);
            }
        });
    }

    public interface ICountChangeListener {
        void onCountChange(Goods goods, int count);
    }

    public void setCountChangeListener(ICountChangeListener mListener) {
        this.mListener = mListener;
    }
}
