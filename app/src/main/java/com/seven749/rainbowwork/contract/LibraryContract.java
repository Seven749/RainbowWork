package com.seven749.rainbowwork.contract;

import com.seven749.rainbowwork.base.IModel;
import com.seven749.rainbowwork.base.IPresenter;
import com.seven749.rainbowwork.base.IView;
import com.seven749.rainbowwork.bean.AlbumBean;
import com.seven749.rainbowwork.bean.AlbumItem;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public interface LibraryContract {
    interface Model extends IModel {
        // refresh
        void refresh();
        // 刷新的响应
        void refreshResponse(String response);

        // get专辑
        void getAlbumList();
        // get专辑的响应
        void getAlbumListResponse(String response);    }

    interface View extends IView {
        // refresh
        void refresh();
        // 刷新的响应
        void refreshResponse(AlbumItem albumItem, boolean isOff);

        // get专辑
        void getAlbumList();
        // get专辑的响应
        void getAlbumListResponse(AlbumItem albumItem);
    }

    interface Presenter extends IPresenter {
        // refresh
        void refresh();
        // 刷新的响应
        void refreshResponse(String response);

        // get专辑
        void getAlbumList();
        // get专辑的响应
        void getAlbumListResponse(String response);    }
}
