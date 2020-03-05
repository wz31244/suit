package com.example.suit.UI.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.suit.R;
import com.example.suit.base.BaseActivity;
import com.example.suit.interfaces.login.RegisterContract;
import com.example.suit.model.apis.RegisterBean;
import com.example.suit.presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements RegisterContract.View, View.OnClickListener {

    private EditText username;
    private EditText password;
    private EditText password_sec;
    private Button register;
    private ConstraintLayout container;
    private String usernameString;
    private String passwordString;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterContract.Presenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        password_sec = (EditText) findViewById(R.id.password_sec);
        register = (Button) findViewById(R.id.register);
        container = (ConstraintLayout) findViewById(R.id.container);

        register.setOnClickListener(this);
    }

    @Override
    protected void initData() { }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password_secString = password_sec.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "确认密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password_secString.equals(passwordString)) {
            //发起登录请求
            presenter.getRegisterData(usernameString, passwordString);
        } else {
            showTips("两次密码输入不一致");
        }
    }

    @Override
    public void getRegisterDataReturn(RegisterBean result) {
        //处理注册请求结果
        Log.i("suit001", "getRegisterDataReturn: " + result.getErrno());
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("username", usernameString);
        intent.putExtra("password", passwordString);
        setResult(RESULT_OK, intent);
        finish();
    }
}
