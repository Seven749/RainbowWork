package com.seven749.rainbowwork.network.getBitmap;

import android.graphics.Bitmap;

/**
 * @author 行云流水
 * @date 2020/4/1
 * @description 获取Bitmap时回调的接口
 */
public interface BitmapCallBack {
    void onResponse(Bitmap bitmap);

    void onFailed(Exception e);
}
