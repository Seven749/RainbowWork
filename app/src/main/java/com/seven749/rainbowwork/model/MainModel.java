package com.seven749.rainbowwork.model;

import android.os.Handler;

import com.seven749.rainbowwork.base.BaseModel;
import com.seven749.rainbowwork.contract.MainContract;

/**
 * @author 行云流水
 * @date 2020/5/1
 * @description
 */
public class MainModel extends BaseModel implements MainContract.Model {
    public MainModel(Handler handler) {
        super(handler);
    }
}
