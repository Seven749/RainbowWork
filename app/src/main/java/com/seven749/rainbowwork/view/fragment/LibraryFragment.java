package com.seven749.rainbowwork.view.fragment;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.seven749.rainbowwork.R;
import com.seven749.rainbowwork.base.BaseFragment;
import com.seven749.rainbowwork.base.IPresenter;
import com.seven749.rainbowwork.bean.AlbumBean;
import com.seven749.rainbowwork.bean.AlbumItem;
import com.seven749.rainbowwork.contract.LibraryContract;
import com.seven749.rainbowwork.presenter.LibraryPresenter;
import com.seven749.rainbowwork.view.adapter.AlbumAdapter;
import com.seven749.rainbowwork.view.adapter.AlbumItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行云流水
 * @date 2020/5/2
 * @description
 */
public class LibraryFragment extends BaseFragment<LibraryContract.Presenter> implements LibraryContract.View {

    private SwipeRefreshLayout swipeRefresh;
    private Context context;
    private List<AlbumItem> albumItemList = new ArrayList<>();
    private AlbumItemAdapter albumAdapter;

    public LibraryFragment(Context context) {
        this.context = context;
    }
    @Override
    public LibraryContract.Presenter initPresenter() {
        return new LibraryPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_library);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(() -> {
            refresh();
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_library);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        albumAdapter = new AlbumItemAdapter(context, albumItemList);
        recyclerView.setAdapter(albumAdapter);
        getAlbumList();
        return view;
    }

    @Override
    public void refresh() {
        albumItemList.clear();
        mPresenter.refresh();
    }

    @Override
    public void refreshResponse(AlbumItem albumItem, boolean isOff) {
        if (isOff) {
            swipeRefresh.setRefreshing(false);
        }
        albumItemList.add(albumItem);
        albumAdapter.notifyDataSetChanged();
    }

    @Override
    public void getAlbumList() {
        albumItemList.clear();
        mPresenter.getAlbumList();
    }

    @Override
    public void getAlbumListResponse(AlbumItem albumItem) {
        albumItemList.add(albumItem);
        albumAdapter.notifyDataSetChanged();
    }
}
