package com.seven749.rainbowwork.model;

import android.os.Handler;

import com.seven749.rainbowwork.base.BaseModel;
import com.seven749.rainbowwork.contract.AccountContract;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class AccountModel extends BaseModel implements AccountContract.Model {
    public AccountModel(Handler handler) {
        super(handler);
    }
}
