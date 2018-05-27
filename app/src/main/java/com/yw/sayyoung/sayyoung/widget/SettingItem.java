package com.yw.sayyoung.sayyoung.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yw.sayyoung.sayyoung.R;

public class SettingItem extends RelativeLayout implements View.OnClickListener{

    ImageView ivIcon;
    TextView tvTitle;
    AppCompatImageView ivLeft;
    TextView tvValue;
    AppCompatCheckBox cbSelect;

    boolean isIconVisible;
    boolean isArrowVisible;
    boolean isSelectVisible;
    boolean isValueVisible;

    String mTextKey;
    String mTextValue;
    Drawable mIconDrawable;


    public SettingItem(Context context) {
        this(context, null);
    }

    public SettingItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_item_mine, this, true);
        ivIcon = (ImageView) findViewById(R.id.iv_icon);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivLeft = (AppCompatImageView) findViewById(R.id.iv_arrow);
        tvValue = (TextView) findViewById(R.id.tv_value);
        cbSelect = (AppCompatCheckBox) findViewById(R.id.cb_select);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SettingItem, 0, 0);
        try {
            mTextKey = typedArray.getString(R.styleable.SettingItem_info_key_text);
            mTextValue = typedArray.getString(R.styleable.SettingItem_info_value_text);
            mIconDrawable = typedArray.getDrawable(R.styleable.SettingItem_info_icon_src);
            isIconVisible = typedArray.getBoolean(R.styleable.SettingItem_info_icon_visible, true);
            isArrowVisible = typedArray.getBoolean(R.styleable.SettingItem_info_arrow_visible, true);
            isSelectVisible = typedArray.getBoolean(R.styleable.SettingItem_info_select_visible, false);
            isValueVisible = typedArray.getBoolean(R.styleable.SettingItem_info_value_visible, false);
        } finally {
            typedArray.recycle();
        }
        if (isIconVisible) {
            if (mIconDrawable != null) {
                ivIcon.setImageDrawable(mIconDrawable);
            }
        } else {
            ivIcon.setVisibility(View.GONE);
        }
        if (isValueVisible) {
            if (mTextValue != null) {
                tvValue.setVisibility(View.VISIBLE);
                tvValue.setText(mTextValue);
            }
        } else {
            tvValue.setVisibility(View.GONE);
        }
        tvTitle.setText(mTextKey);
        ivLeft.setVisibility(isArrowVisible ? View.VISIBLE : View.GONE);
        cbSelect.setVisibility(isSelectVisible ? View.VISIBLE : View.GONE);
        cbSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
