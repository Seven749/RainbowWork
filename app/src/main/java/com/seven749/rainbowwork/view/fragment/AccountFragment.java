package com.seven749.rainbowwork.view.fragment;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.seven749.rainbowwork.App;
import com.seven749.rainbowwork.R;
import com.seven749.rainbowwork.base.BaseFragment;
import com.seven749.rainbowwork.contract.AccountContract;
import com.seven749.rainbowwork.presenter.AccountPresenter;
import com.seven749.rainbowwork.utils.normal.RestartApp;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class AccountFragment extends BaseFragment<AccountContract.Presenter> implements AccountContract.View {
    private Context context;

    public AccountFragment(Context context) {
        this.context = context;
    }
    @Override
    public AccountContract.Presenter initPresenter() {
        return new AccountPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.avatar);
        // 获取屏幕宽度
//        Display display = getActivity().getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//        int widths = size.x;
//        int height = size.y;
//        Log.d(TAG, "onCreateView: " + widths);
//        Log.d(TAG, "onCreateView: " + height);
        Glide.with(context).load(App.avatarUrl).into(imageView);
        TextView nicknameText = (TextView) view.findViewById(R.id.nick_name);
        TextView followedsText = (TextView) view.findViewById(R.id.followeds_num);
        TextView eventCountText = (TextView) view.findViewById(R.id.event_count_num);
        TextView followsText = (TextView) view.findViewById(R.id.follows_num);
        nicknameText.setText(App.nickname);
        followedsText.setText(App.followeds);
        eventCountText.setText(App.eventCount);
        followsText.setText(App.follows);

        Button loginOutButton = (Button) view.findViewById(R.id.button_login_out);
        loginOutButton.setOnClickListener(v -> {
            App.isLogin = false;
            App.token = null;
            App.nickname = null;
            App.avatarUrl = null;
            App.followeds = null;
            App.eventCount = null;
            App.follows = null;
            RestartApp.run(context);
        });
        return view;
    }
}
