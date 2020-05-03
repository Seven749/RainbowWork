package com.seven749.rainbowwork.view.activity;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.seven749.rainbowwork.R;
import com.seven749.rainbowwork.base.BaseActivity;
import com.seven749.rainbowwork.contract.MainContract;
import com.seven749.rainbowwork.presenter.MainPresenter;
import com.seven749.rainbowwork.utils.normal.DoubleClickExitHelper;
import com.seven749.rainbowwork.view.adapter.ViewPageAdapter;
import com.seven749.rainbowwork.view.fragment.AccountFragment;
import com.seven749.rainbowwork.view.fragment.HomeFragment;
import com.seven749.rainbowwork.view.fragment.LibraryFragment;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {

    private ViewPager viewPager;
    private MenuItem menuItem;
    private DoubleClickExitHelper doubleClickExitHelper = new DoubleClickExitHelper(this);

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.flame:
                            viewPager.setCurrentItem(0);
                            return true;
                        case R.id.library:
                            viewPager.setCurrentItem(1);
                            return true;
                        case R.id.account:
                            viewPager.setCurrentItem(2);
                            return true;
                    }
                    return false;
                }
            };

    @Override
    public MainContract.Presenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_paper);
        final BottomNavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        //
        setupViewPager();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null)
                    menuItem.setChecked(false);
                else navigationView.getMenu().getItem(0).setChecked(false);
                menuItem = navigationView.getMenu().getItem(position);
                menuItem.setChecked(true);            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupViewPager() {
        // 创建Fragment对象
        HomeFragment homeFragment = new HomeFragment(this);
        LibraryFragment libraryFragment = new LibraryFragment(this);
        AccountFragment accountFragment = new AccountFragment(this);

        // 创建适配器
        ViewPageAdapter adaptor = new ViewPageAdapter(getSupportFragmentManager());
        // 添加Fragment
        adaptor.addFragment(homeFragment);
        adaptor.addFragment(libraryFragment);
        adaptor.addFragment(accountFragment);
        // 设置适配器
        viewPager.setAdapter(adaptor);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return doubleClickExitHelper.onKeyDown(keyCode);
    }
}
