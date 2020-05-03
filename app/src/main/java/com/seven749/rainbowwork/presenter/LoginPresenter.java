package com.seven749.rainbowwork.presenter;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.seven749.rainbowwork.base.BasePresenter;
import com.seven749.rainbowwork.contract.LoginContract;
import com.seven749.rainbowwork.model.LoginModel;

import org.json.JSONObject;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public LoginContract.Model initModel(Handler handler) {
        return new LoginModel(handler);
    }

    @Override
    public void modelResponse(Message msg) {
        switch (msg.what) {
            case 1001:
                loginResponse(msg.obj.toString());
                break;

        }
    }

    @Override
    public void login(String phone, String password) {
        mModel.login(phone, password);
    }

    @Override
    public void loginResponse(String response) {
        parseLogin(response);
    }

    void parseLogin(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String code = jsonObject.getString("code");
            if (code.equals("200")) {
                String token = jsonObject.getString("token");
                Log.d(TAG, "parseLogin: " + token);
                JSONObject profile = jsonObject.getJSONObject("profile");
                String id = jsonObject.getJSONObject("account").getString("id");
                Log.d(TAG, "parseLogin: " + id );
                String nickname = profile.getString("nickname");
                String avatarUrl = profile.getString("avatarUrl");
                String followeds = profile.getString("followeds");
                String follows = profile.getString("follows");
                String eventCount = profile.getString("eventCount");
                mView.loginResponse(token, id, nickname, avatarUrl, followeds, follows, eventCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
