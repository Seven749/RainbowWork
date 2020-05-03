package com.seven749.rainbowwork.model;

import android.os.Handler;
import android.os.Message;

import com.seven749.rainbowwork.App;
import com.seven749.rainbowwork.R;
import com.seven749.rainbowwork.base.BaseModel;
import com.seven749.rainbowwork.contract.LibraryContract;
import com.seven749.rainbowwork.network.httphelper.CallBack;
import com.seven749.rainbowwork.network.httphelper.NetUtil;
import com.seven749.rainbowwork.network.httphelper.Request;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class LibraryModel extends BaseModel implements LibraryContract.Model {

    public LibraryModel(Handler handler) {
        super(handler);
    }

    @Override
    public void refresh() {
        Request request = new Request.Builder()
                .url("http://47.99.165.194/user/playlist?uid=" + App.id + "&limit=50")
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
        message.what = 3001;
        message.obj = response;
        sendMessage(message);
    }

    @Override
    public void getAlbumList() {
        Request request = new Request.Builder()
                .url("http://47.99.165.194/user/playlist?uid=" + App.id + "&limit=50")
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
        message.what = 3002;
        message.obj = response;
        sendMessage(message);
    }
}
