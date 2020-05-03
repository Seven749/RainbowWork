package com.seven749.rainbowwork.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.seven749.rainbowwork.base.BaseModel;
import com.seven749.rainbowwork.contract.HomeContract;
import com.seven749.rainbowwork.network.httphelper.CallBack;
import com.seven749.rainbowwork.network.httphelper.NetUtil;
import com.seven749.rainbowwork.network.httphelper.Request;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class HomeModel extends BaseModel implements HomeContract.Model {

    private static final String TAG = "HomeModel";

    public HomeModel(Handler handler) {
        super(handler);
    }

    @Override
    public void initBanner() {
        Request request = new Request.Builder()
                .url("http://47.99.165.194/album/newest")
                .build();
        NetUtil.getInstance().execute(request, new CallBack() {
            @Override
            public void onResponse(String response) {
                initBannerResponse(response);
            }

            @Override
            public void onFailed(Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initBannerResponse(String response) {
        Message message = new Message();
        message.what = 2001;
        message.obj = response;
        sendMessage(message);
        Log.d(TAG, "initBannerResponse: sendMessage 2001");
    }

    @Override
    public void refresh() {
        Request request = new Request.Builder()
                .url("http://47.99.165.194/top/playlist?limit=20")
                .build();
        NetUtil.getInstance().execute(request, new CallBack() {
            @Override
            public void onResponse(String response) {
                refreshResponse(response);
            }

            @Override
            public void onFailed(Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void refreshResponse(String response) {
        Message message = new Message();
        message.what = 2003;
        message.obj = response;
        sendMessage(message);
        Log.d(TAG, "refreshResponse: 2003");
    }

    @Override
    public void getAlbumList() {
        Request request = new Request.Builder()
                .url("http://47.99.165.194/top/playlist?limit=20")
                .build();
        NetUtil.getInstance().execute(request, new CallBack() {
            @Override
            public void onResponse(String response) {
                getAlbumListResponse(response);
            }

            @Override
            public void onFailed(Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void getAlbumListResponse(String response) {
        Message message = new Message();
        message.what = 2002;
        message.obj = response;
        sendMessage(message);
        Log.d(TAG, "getAlbumListResponse: sendMessage 2002");
    }
}
