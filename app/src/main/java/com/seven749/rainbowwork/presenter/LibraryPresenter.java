package com.seven749.rainbowwork.presenter;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.seven749.rainbowwork.base.BasePresenter;
import com.seven749.rainbowwork.bean.AlbumItem;
import com.seven749.rainbowwork.contract.LibraryContract;
import com.seven749.rainbowwork.model.LibraryModel;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class LibraryPresenter extends BasePresenter<LibraryContract.Model, LibraryContract.View> implements LibraryContract.Presenter {

    private static final String TAG = "LibraryPresenter";

    public LibraryPresenter(LibraryContract.View view) {
        super(view);
    }

    @Override
    public LibraryContract.Model initModel(Handler handler) {
        return new LibraryModel(handler);
    }

    @Override
    public void modelResponse(Message msg) {
        switch (msg.what) {
            case 3001:
                refreshResponse(msg.obj.toString());
                break;
            case 3002:
                getAlbumListResponse(msg.obj.toString());
                break;
        }
    }

    @Override
    public void refresh() {
        mModel.refresh();
    }

    @Override
    public void refreshResponse(String response) {
        parseRefresh(response);
    }

    private void parseRefresh(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String code = jsonObject.getString("code");
            Log.d(TAG, "parseRefresh: " + code);
            if (code.equals("200")) {
                JSONArray jsonArray = new JSONArray(jsonObject.getString("playlist"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject album = jsonArray.getJSONObject(i);
                    String name = album.getString("name");
                    String id = album.getString("id");
                    String coverImgUrl = album.getString("coverImgUrl");
                    String nickname = album.getJSONObject("creator").getString("nickname");
                    Log.d(TAG, "parseRefresh: " + nickname);
                    AlbumItem albumItem = new AlbumItem(name, id, coverImgUrl, nickname);
                    boolean isOff = false;
                    if (i == jsonArray.length() - 1) {
                        isOff = true;
                    }
                    mView.refreshResponse(albumItem, isOff);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void getAlbumList() {
        mModel.getAlbumList();
    }

    @Override
    public void getAlbumListResponse(String response) {
        parseGet(response);
    }

    private void parseGet(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String code = jsonObject.getString("code");
            Log.d(TAG, "parseRefresh: " + code);
            if (code.equals("200")) {
                JSONArray jsonArray = new JSONArray(jsonObject.getString("playlist"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject album = jsonArray.getJSONObject(i);
                    String name = album.getString("name");
                    String id = album.getString("id");
                    String coverImgUrl = album.getString("coverImgUrl");
                    String nickname = album.getJSONObject("creator").getString("nickname");
                    Log.d(TAG, "parseRefresh: " + nickname);
                    AlbumItem albumItem = new AlbumItem(name, id, coverImgUrl, nickname);
                    mView.getAlbumListResponse(albumItem);
                }
            }        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
