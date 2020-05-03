package com.seven749.rainbowwork.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.seven749.rainbowwork.R;
import com.seven749.rainbowwork.base.BaseFragment;
import com.seven749.rainbowwork.bean.AlbumBean;
import com.seven749.rainbowwork.bean.BannerBean;
import com.seven749.rainbowwork.contract.HomeContract;
import com.seven749.rainbowwork.presenter.HomePresenter;
import com.seven749.rainbowwork.view.adapter.AlbumAdapter;
import com.seven749.rainbowwork.view.adapter.BannerAdapter;
import com.seven749.rainbowwork.view.widget.AutoPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class HomeFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View {

    private SwipeRefreshLayout swipeRefresh;
    private AlbumAdapter albumAdapter;

    public HomeFragment(Context context) {
        this.context = context;
    }

    private Context context;
    private BannerAdapter bannerAdapter;
    private AutoPlayer player;
    private List<BannerBean> bannerBeans = new ArrayList<>();
    private List<AlbumBean> albumBeans = new ArrayList<>();

    @Override
    public HomeContract.Presenter initPresenter() {
        return new HomePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        player = (AutoPlayer) view.findViewById(R.id.bannerPlayer);
//        bannerAdapter = new BannerAdapter(context);
//        player.setAdapter(bannerAdapter);
        initBanner();
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_home);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(() -> {
            refresh();
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        albumAdapter = new AlbumAdapter(context, albumBeans);
        recyclerView.setAdapter(albumAdapter);
        getAlbumList();
        return view;
    }

    @Override
    public void initBanner() {
        mPresenter.initBanner();
    }

    @Override
    public void initBannerResponse(boolean is, BannerBean bean, boolean isOver) {
        if (is) {
//            Toast.makeText(context, "添加banner条目", Toast.LENGTH_SHORT).show();
            bannerBeans.add(bean);
        } else {
            Toast.makeText(context, "似乎出了点问题...", Toast.LENGTH_SHORT).show();
        }
        if (isOver) {
            bannerAdapter = new BannerAdapter(context, bannerBeans);
            player.setAdapter(bannerAdapter);
            bannerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void refresh() {
        albumBeans.clear();
        mPresenter.refresh();
    }

    @Override
    public void refreshResponse(AlbumBean albumBean, boolean isOff) {
        if (isOff) {
            swipeRefresh.setRefreshing(false);
            Log.d(TAG, "refreshResponse: Over");
        }
        albumBeans.add(albumBean);
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void getAlbumList() {
        albumBeans.clear();
        mPresenter.getAlbumList();
    }

    @Override
    public void getAlbumListResponse(AlbumBean albumBean) {
        albumBeans.add(albumBean);
        albumAdapter.notifyDataSetChanged();
    }
}
