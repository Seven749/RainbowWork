package com.seven749.rainbowwork.contract;

import com.seven749.rainbowwork.base.IModel;
import com.seven749.rainbowwork.base.IPresenter;
import com.seven749.rainbowwork.base.IView;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public interface LoginContract {
    interface Model extends IModel {
        // 登录
        void login(String phone, String password);
        // 登录响应
        void loginResponse(String response);
    }

    interface View extends IView {
        // 登录
        void login(String phone, String password);
        // 登录响应
        void loginResponse(String token, String id, String nickname, String avatarUrl, String followeds, String follows, String eventCount);
    }

    interface Presenter extends IPresenter {
        // 登录
        void login(String phone, String password);
        // 登录响应
        void loginResponse(String response);
    }
}
