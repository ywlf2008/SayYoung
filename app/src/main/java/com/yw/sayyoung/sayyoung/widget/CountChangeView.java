package com.yw.sayyoung.sayyoung.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yw.sayyoung.sayyoung.R;

public class CountChangeView extends LinearLayout implements View.OnClickListener {

    public static final int MAX_COUNT = 9999;
    private Context mContext;
    TextView mTvReduce;
    EditText mTvCount;
    TextView mTvAdd;
    int mCount = 1;
    ICountChangeListener mListener;

    public CountChangeView(Context context) {
        this(context, null);
    }

    public CountChangeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountChangeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_count_change, this, true);
        mTvReduce = (TextView) findViewById(R.id.tv_reduce);
        mTvCount = (EditText) findViewById(R.id.tv_count);
        mTvAdd = (TextView) findViewById(R.id.tv_add);

        mTvReduce.setOnClickListener(this);
        mTvAdd.setOnClickListener(this);
        mTvCount.setOnClickListener(this);
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
    }

    public void setCountChangeListener(ICountChangeListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_reduce:
                if (mCount > 1) {
                    mCount--;
                    if (mListener != null) {
                        mListener.onCountChange(mCount);
                    }
                    mTvCount.setText(String.valueOf(mCount));
                } else {
                    Toast.makeText(mContext, "数量不能为零", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_add:
                if (mCount < MAX_COUNT) {
                    mCount++;
                    if (mListener != null) {
                        mListener.onCountChange(mCount);
                    }
                    mTvCount.setText(String.valueOf(mCount));
                } else {
                    Toast.makeText(mContext, "数量最大为9999", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public interface ICountChangeListener {
        void onCountChange(int count);
    }
}
