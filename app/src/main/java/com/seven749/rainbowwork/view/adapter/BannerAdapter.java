package com.seven749.rainbowwork.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.seven749.rainbowwork.bean.BannerBean;
import com.seven749.rainbowwork.contract.HomeContract;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class BannerAdapter extends PagerAdapter {

    private static final String TAG = "BannerAdapter";
    private Context context;
    private List<BannerBean> resIds;

    public BannerAdapter(Context context, List<BannerBean> bannerBeans ) {
        this.context = context;
        resIds = bannerBeans;
    }

    public int getListSize(){
        return resIds == null ? 0 : resIds.size();
    }

    @Override
    public int getCount() {
        return resIds == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        position = position % getListSize();
        View itemView = getItemView(container,position);
        container.addView(itemView);
        return itemView;
    }

    public void addBanner (BannerBean bean) {
        resIds.add(bean);
    }

    public View getItemView(ViewGroup container, int itemPosition){
        ImageView imageView = new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        String picUrl = resIds.get(itemPosition).getPicUrl();
        //加载网络图片 这里要用Glide 或者imageLoader
        if (!TextUtils.isEmpty(picUrl)){
            Glide.with(context).load(picUrl).into(imageView);
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View)object);
    }
}