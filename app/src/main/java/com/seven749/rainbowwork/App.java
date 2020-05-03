package com.seven749.rainbowwork;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * @author 行云流水
 * @date 2020/5/1
 * @description
 */
public class App extends Application {

    private static final String TAG = "App";
    public static boolean isLogin = false;
    public static String id;
    public static String token;
    public static String nickname;
    public static String avatarUrl;
    public static String followeds;
    public static String follows;
    public static String eventCount;
    private static App mApp;

    public static App getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        //App初始化操作
        SharedPreferences preferences = getSharedPreferences("loginInfo", MODE_PRIVATE);
        isLogin = preferences.getBoolean("isLogin", false);
        id = preferences.getString("id", null);
        token = preferences.getString("token", null);
        nickname = preferences.getString("nickname", null);
        avatarUrl = preferences.getString("avatarUrl", null);
        followeds = preferences.getString("followeds", null);
        follows = preferences.getString("follows", null);
        Log.d(TAG, "onCreate: "+ follows);
        eventCount = preferences.getString("eventCount", null);
        Log.d(TAG, "onCreate: " + isLogin);
    }
}