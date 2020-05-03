package com.seven749.rainbowwork.presenter;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.seven749.rainbowwork.base.BasePresenter;
import com.seven749.rainbowwork.bean.AlbumBean;
import com.seven749.rainbowwork.bean.BannerBean;
import com.seven749.rainbowwork.contract.HomeContract;
import com.seven749.rainbowwork.model.HomeModel;
import com.seven749.rainbowwork.view.fragment.HomeFragment;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> implements HomeContract.Presenter {
    private static final String TAG = "HomePresenter";

    public HomePresenter(HomeContract.View view) {
        super(view);
    }

    @Override
    public HomeContract.Model initModel(Handler handler) {
        return new HomeModel(handler);
    }

    @Override
    public void modelResponse(Message msg) {
        switch (msg.what) {
            case 2001:
                Log.d(TAG, "modelResponse: getMessage 2001");
                initBannerResponse(msg.obj.toString());
                break;
            case 2002:
                Log.d(TAG, "modelResponse: getMessage 2002");
                getAlbumListResponse(msg.obj.toString());
                break;
            case 2003:
                Log.d(TAG, "modelResponse: getMessage 2003");
                refreshResponse(msg.obj.toString());
                break;
        }
    }

    @Override
    public void initBanner() {
        mModel.initBanner();
    }

    @Override
    public void initBannerResponse(String response) {
        parseBanner(response);
    }

    private void parseBanner(String response) {
        Log.d(TAG, "parseBanner: start");
        try {
            JSONObject jsonObject = new JSONObject(response);
            String code = jsonObject.getString("code");
            Log.d(TAG, "parseBanner: " + code);
            if (code.equals("200")) {
                JSONArray jsonArray = new JSONArray(jsonObject.getString("albums"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject album = jsonArray.getJSONObject(i);
                    String name = album.getString("name");
                    String id = album.getString("id");
                    String picUrl = album.getString("picUrl");
                    String artistName = album.getJSONObject("artist").getString("name");
//                    String song = album.getString("song");
                    boolean paid = album.getBoolean("paid");
                    Log.d(TAG, "parseBanner: " + name);
                    Log.d(TAG, "parseBanner: " + id);
                    Log.d(TAG, "parseBanner: " + picUrl);
                    Log.d(TAG, "parseBanner: " + artistName);
//                    Log.d(TAG, "parseBanner: " + song);
                    Log.d(TAG, "parseBanner: " + paid);
                    BannerBean bannerBean = new BannerBean(name, id, picUrl, artistName, paid);
                    boolean isOver = false;
                    if (i == jsonArray.length() - 1) {
                        isOver = true;
                    }
                    mView.initBannerResponse(true , bannerBean, isOver);
                }
            } else {
                mView.initBannerResponse(false, null, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refresh() {
        mModel.refresh();
    }

    @Override
    public void refreshResponse(String response) {
        Log.d(TAG, "refreshResponse: parseRefresh");
        parseRefresh(response);
    }

    private void parseRefresh(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String code = jsonObject.getString("code");
            Log.d(TAG, "parseRefresh: " + code);
            if (code.equals("200")) {
                JSONArray jsonArray = new JSONArray(jsonObject.getString("playlists"));
                Log.d(TAG, "parseRefresh: " + jsonArray);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject album = jsonArray.getJSONObject(i);
                    String name = album.getString("name");
                    String id = album.getString("id");
                    String coverImgUrl = album.getString("coverImgUrl");
                    String description = album.getString("description");
                    String nickName = album.getJSONObject("creator").getString("nickname");
                    String userId = album.getJSONObject("creator").getString("userId");
                    Log.d(TAG, "parseRefresh: " + name);
                    Log.d(TAG, "parseRefresh: " + id);
                    Log.d(TAG, "parseRefresh: " + coverImgUrl);
                    Log.d(TAG, "parseRefresh: " + description);
                    Log.d(TAG, "parseRefresh: " + nickName);
                    Log.d(TAG, "parseRefresh: " + userId);
                    AlbumBean albumBean = new AlbumBean(name, id, coverImgUrl, description, nickName, userId);
                    boolean isOff = false;
                    if (i == jsonArray.length() - 1) {
                        isOff = true;
                    }
                    mView.refreshResponse(albumBean, isOff);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "parseRefresh: over");
    }

    @Override
    public void getAlbumList() {
        mModel.getAlbumList();
    }

    @Override
    public void getAlbumListResponse(String response) {
        Log.d(TAG, "getAlbumListResponse: parseGetAlbumList");
        parseGetAlbumList(response);
    }

    private void parseGetAlbumList(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String code = jsonObject.getString("code");
            Log.d(TAG, "parseGetAlbumList: " + code);
            if (code.equals("200")) {
                JSONArray jsonArray = new JSONArray(jsonObject.getString("playlists"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject album = jsonArray.getJSONObject(i);
                    String name = album.getString("name");
                    String id = album.getString("id");
                    String coverImgUrl = album.getString("coverImgUrl");
                    String description = album.getString("description");
                    String nickName = album.getJSONObject("creator").getString("nickname");
                    String userId = album.getJSONObject("creator").getString("userId");
                    Log.d(TAG, "parseGetAlbumList: " + name);
                    Log.d(TAG, "parseGetAlbumList: " + id);
                    Log.d(TAG, "parseGetAlbumList: " + coverImgUrl);
                    Log.d(TAG, "parseGetAlbumList: " + description);
                    Log.d(TAG, "parseGetAlbumList: " + nickName);
                    Log.d(TAG, "parseGetAlbumList: " + userId);
                    AlbumBean albumBean = new AlbumBean(name, id, coverImgUrl, description, nickName, userId);
                    mView.getAlbumListResponse(albumBean);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "parseGetAlbumList: over");
    }
}
