package com.yw.sayyoung.sayyoung.ui.activity;

import android.content.Intent;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yw.sayyoung.sayyoung.R;
import com.yw.sayyoung.sayyoung.app.Constants;
import com.yw.sayyoung.sayyoung.app.SayYoungApp;
import com.yw.sayyoung.sayyoung.base.activity.BaseActivity;
import com.yw.sayyoung.sayyoung.contract.LoginContract;
import com.yw.sayyoung.sayyoung.core.bean.Account;
import com.yw.sayyoung.sayyoung.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class Login1Activity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.login_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.et_username)
    AutoCompleteTextView mEtUsername;
    @BindView(R.id.password)
    EditText mEtPassword;
    @BindView(R.id.email_sign_in_button)
    Button mBtnLogin;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData() {
        Intent intent = new Intent();
        intent.putExtra(Constants.EXTRA_LOGIN, false);
        setResult(Constants.RESULT_LOGIN, intent);
    }

    @OnClick({R.id.email_sign_in_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_sign_in_button:
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    Intent intent = new Intent();
                    intent.putExtra(Constants.EXTRA_LOGIN, true);
                    setResult(Constants.RESULT_LOGIN, intent);
                    Account account = new Account(username);
                    SayYoungApp.getInstance().mAccount = account;
                    mPresenter.setLoginStatus(true);
                    mPresenter.setLoginAccount(username);
                    finish();
                }else{
                    Toast.makeText(mActivity, R.string.error_pws_user_incorrect, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

}
