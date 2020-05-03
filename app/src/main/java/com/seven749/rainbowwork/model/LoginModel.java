package com.seven749.rainbowwork.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.seven749.rainbowwork.base.BaseModel;
import com.seven749.rainbowwork.contract.LoginContract;
import com.seven749.rainbowwork.network.httphelper.CallBack;
import com.seven749.rainbowwork.network.httphelper.NetUtil;
import com.seven749.rainbowwork.network.httphelper.Request;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class LoginModel extends BaseModel implements LoginContract.Model {
    private static final String TAG = "LoginModel";

    public LoginModel(Handler handler) {
        super(handler);
    }

    @Override
    public void login(String phone, String password) {
        Request request = new Request.Builder()
                .url("https://autumnfish.cn/login/cellphone?phone=" + phone + "&password=" + password)
                .build();
        NetUtil.getInstance().execute(request, new CallBack() {
            @Override
            public void onResponse(String response) {
                loginResponse(response);
            }

            @Override
            public void onFailed(Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void loginResponse(String response) {
        Message message = new Message();
        message.what = 1001;
        message.obj = response;
        sendMessage(message);
        Log.d(TAG, "loginResponse: sendMessage");
    }
}
