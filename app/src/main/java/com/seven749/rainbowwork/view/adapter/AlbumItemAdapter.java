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
import com.seven749.rainbowwork.bean.AlbumItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class AlbumItemAdapter extends RecyclerView.Adapter<AlbumItemAdapter.ViewHolder> {

    private Context context;
    private List<AlbumItem> albumItemList = new ArrayList<>();

    @NonNull
    @Override
    public AlbumItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_album_library, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumItemAdapter.ViewHolder holder, int position) {
        AlbumItem albumItem = albumItemList.get(position);
        Glide.with(context).load(albumItem.getCoverImgUrl()).into(holder.albumPic);
        holder.nameText.setText(albumItem.getName());
        holder.nickNameText.setText(albumItem.getNickname());
    }

    @Override
    public int getItemCount() {
        return albumItemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View albumView;
        ImageView albumPic;
        TextView nameText, nickNameText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumView = itemView;
            albumPic = (ImageView) itemView.findViewById(R.id.album_pic_library);
            nameText = (TextView) itemView.findViewById(R.id.album_name_library);
            nickNameText = (TextView) itemView.findViewById(R.id.album_nick_name_library);
        }
    }

    public AlbumItemAdapter(Context context, List<AlbumItem> albumItemList){
        this.context = context;
        this.albumItemList = albumItemList;
    }
}
