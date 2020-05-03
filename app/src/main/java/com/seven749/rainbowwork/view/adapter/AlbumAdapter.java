package com.seven749.rainbowwork.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.seven749.rainbowwork.R;
import com.seven749.rainbowwork.bean.AlbumBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private List<AlbumBean> albumBeanList = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adpater_album_home, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        AlbumBean albumBean = albumBeanList.get(position);
        Glide.with(context).load(albumBean.getCoverImgUrl()).into(holder.albumPic);
        holder.nameText.setText(albumBean.getName());
        holder.nickNameText.setText(albumBean.getNickName());
    }

    @Override
    public int getItemCount() {
        return albumBeanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View albumView;
        ImageView albumPic;
        TextView nameText, nickNameText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumView = itemView;
            albumPic = (ImageView) itemView.findViewById(R.id.album_pic_home);
            nameText = (TextView) itemView.findViewById(R.id.album_name_home);
            nickNameText = (TextView) itemView.findViewById(R.id.album_nick_name_home);
        }
    }
    public AlbumAdapter(Context context, List<AlbumBean> albumBeanList) {
        this.context = context;
        this.albumBeanList = albumBeanList;
    }
}
