package com.seven749.rainbowwork.contract;

import com.seven749.rainbowwork.base.IModel;
import com.seven749.rainbowwork.base.IPresenter;
import com.seven749.rainbowwork.base.IView;
import com.seven749.rainbowwork.bean.AlbumBean;
import com.seven749.rainbowwork.bean.BannerBean;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public interface HomeContract {
    interface Model extends IModel {
        // 初始化banner
        void initBanner();
        // 初始化banner的响应
        void initBannerResponse(String response);

        // refresh
        void refresh();
        // 刷新的响应
        void refreshResponse(String response);

        // get专辑
        void getAlbumList();
        // get专辑的响应
        void getAlbumListResponse(String response);
    }

    interface View extends IView {
        // 初始化banner
        void initBanner();
        // 初始化banner的响应
        void initBannerResponse(boolean is, BannerBean bean, boolean isOver);

        // refresh
        void refresh();
        // 刷新的响应
        void refreshResponse(AlbumBean albumBean, boolean isOff);

        // get专辑
        void getAlbumList();
        // get专辑的响应
        void getAlbumListResponse(AlbumBean albumBean);
    }

    interface Presenter extends IPresenter {
        // 初始化banner
        void initBanner();
        // 初始化banner的响应
        void initBannerResponse(String response);

        // refresh
        void refresh();
        // 刷新的响应
        void refreshResponse(String response);

        // get专辑
        void getAlbumList();
        // get专辑的响应
        void getAlbumListResponse(String response);
    }
}
