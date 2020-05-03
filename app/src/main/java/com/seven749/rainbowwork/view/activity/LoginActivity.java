package com.seven749.rainbowwork.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.seven749.rainbowwork.App;
import com.seven749.rainbowwork.R;
import com.seven749.rainbowwork.base.BaseActivity;
import com.seven749.rainbowwork.contract.LoginContract;
import com.seven749.rainbowwork.presenter.LoginPresenter;
import com.seven749.rainbowwork.utils.normal.DoubleClickExitHelper;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {

    private DoubleClickExitHelper doubleClickExitHelper = new DoubleClickExitHelper(this);

    @Override
    public LoginContract.Presenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText phoneText = (EditText) findViewById(R.id.phone_login);
        EditText passwordText = (EditText) findViewById(R.id.password_login);
        Button loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: loginButton onClicked");
            if (!phoneText.getText().toString().equals(null) && !passwordText.getText().toString().equals(null)) {
                Log.d(TAG, "onCreate: login");
                login(phoneText.getText().toString(), passwordText.getText().toString());
            } else {
                Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            }
        });
        if (App.isLogin) {
            toMain();
        }
    }

    @Override
    public void login(String phone, String password) {
        mPresenter.login(phone, password);
    }

    @Override
    public void loginResponse(String token, String id, String nickname, String avatarUrl, String followeds, String follows, String eventCount) {
        App.isLogin = true;
        App.id = id;
        App.token = token;
        App.nickname = nickname;
        App.avatarUrl = avatarUrl;
        App.followeds = followeds;
        App.follows = follows;
        App.eventCount = eventCount;
        Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
        toMain();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences.Editor editor = getSharedPreferences("loginInfo", MODE_PRIVATE).edit();
        editor.putBoolean("isLogin", App.isLogin);
        editor.putString("token", App.token);
        editor.putString("nickname", App.nickname);
        editor.putString("avatarUrl", App.avatarUrl);
        editor.putString("followeds", App.followeds);
        editor.putString("follows", App.follows);
        editor.putString("eventCount", App.eventCount);
        editor.apply();
        Log.d(TAG, "onDestroy: loginInfo apply");
    }

    private void toMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return doubleClickExitHelper.onKeyDown(keyCode);
    }
}
