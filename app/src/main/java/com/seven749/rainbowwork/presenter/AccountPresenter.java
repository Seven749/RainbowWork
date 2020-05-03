package com.seven749.rainbowwork.presenter;

import android.os.Handler;
import android.os.Message;

import com.seven749.rainbowwork.base.BasePresenter;
import com.seven749.rainbowwork.contract.AccountContract;
import com.seven749.rainbowwork.model.AccountModel;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class AccountPresenter extends BasePresenter<AccountContract.Model, AccountContract.View> implements AccountContract.Presenter {
    public AccountPresenter(AccountContract.View view) {
        super(view);
    }

    @Override
    public AccountContract.Model initModel(Handler handler) {
        return new AccountModel(handler);
    }

    @Override
    public void modelResponse(Message msg) {

    }
}
