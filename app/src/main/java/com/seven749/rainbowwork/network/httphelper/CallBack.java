package com.seven749.rainbowwork.network.httphelper;

/**
 * @author 行云流水
 * @date 2020/3/24
 * @description 网络请求时需要回调的接口
 */
public interface CallBack {

    void onResponse(String response);

    void onFailed(Exception e);
}
