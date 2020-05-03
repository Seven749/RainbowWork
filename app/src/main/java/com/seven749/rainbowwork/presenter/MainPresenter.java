package com.seven749.rainbowwork.presenter;

import android.os.Handler;
import android.os.Message;

import com.seven749.rainbowwork.base.BasePresenter;
import com.seven749.rainbowwork.base.IModel;
import com.seven749.rainbowwork.base.IView;
import com.seven749.rainbowwork.contract.MainContract;
import com.seven749.rainbowwork.model.MainModel;

/**
 * @author 行云流水
 * @date 2020/5/1
 * @description
 */
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> implements MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public MainContract.Model initModel(Handler handler) {
        return new MainModel(handler);
    }

    @Override
    public void modelResponse(Message msg) {

    }
}
