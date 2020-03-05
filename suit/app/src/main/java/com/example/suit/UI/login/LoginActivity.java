package com.example.suit.UI.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.suit.R;
import com.example.suit.base.BaseActivity;
import com.example.suit.interfaces.login.LoginContract;
import com.example.suit.model.apis.LoginBean;
import com.example.suit.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View, View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;
    private ConstraintLayout container;
    private Button register;
    private Button forgot;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginContract.Presenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = findViewById(R.id.register);
        forgot = findViewById(R.id.forgot);
        container = (ConstraintLayout) findViewById(R.id.container);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        forgot.setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                toLogin();
                break;
            case R.id.register:
                toRegister();
                break;
        }
    }

    /*
        跳转注册页面
     */
    private void toRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == RESULT_OK) {
            username.setText(data.getStringExtra("username"));
            password.setText(data.getStringExtra("password"));
        }
    }

    /*
            开始登录
         */
    private void toLogin() {
        // validate
        String usernameString = username.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        //发起登录请求
        presenter.getLoginData(usernameString, passwordString);
    }

    @Override
    public void getLoginDataReturn(LoginBean result) {
        //处理登录请求结果
        Log.i("suit001", "getLoginDataReturn: " + result.getErrno());
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
