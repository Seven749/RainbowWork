package com.seven749.rainbowwork.view.adapter;

import android.content.Context;
import android.util.Log;
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
import com.seven749.rainbowwork.bean.AlbumProgramItemBean;
import com.seven749.rainbowwork.music.AudioPlayer;
import com.seven749.rainbowwork.music.PlayerService;
import com.seven749.rainbowwork.network.httphelper.CallBack;
import com.seven749.rainbowwork.network.httphelper.NetUtil;
import com.seven749.rainbowwork.network.httphelper.Request;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private static final String TAG = "AlbumAdapter";
    private List<AlbumBean> albumBeanList = new ArrayList<>();
    private Context context;

    public AlbumAdapter(Context context, List<AlbumBean> albumBeanList) {
        this.context = context;
        this.albumBeanList = albumBeanList;
    }

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
        holder.albumView.setOnClickListener(v -> {
            Request request = new Request.Builder()
                    .url("http://47.99.165.194/playlist/detail?id=" + albumBean.getId())
                    .build();
            NetUtil.getInstance().execute(request, new CallBack() {
                @Override
                public void onResponse(String response) {
                    parseAlbumDetail(response);
                }

                @Override
                public void onFailed(Exception e) {
                    e.printStackTrace();
                }
            });
        });
    }

    @Override
    public int getItemCount() {
        return albumBeanList.size();
    }

    private void parseAlbumDetail(String response) {
        try {
            List<AlbumProgramItemBean> list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(response);
            String code = jsonObject.getString("code");
            if (code.equals("200")) {
                JSONArray jsonArray = new JSONArray(jsonObject.getJSONObject("playlist").getString("tracks"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject song = jsonArray.getJSONObject(i);
                    String fee = song.getString("fee");
                    Log.d(TAG, "parseAlbumDetail: " + fee);
                    String name = song.getString("name");
                    String id = song.getString("id");
                    String picUrl = song.getJSONObject("al").getString("picUrl");
//                    Log.d(TAG, "parseAlbumDetail: " + name);
//                    Log.d(TAG, "parseAlbumDetail: " + id);
//                    Log.d(TAG, "parseAlbumDetail: " + picUrl);
                    AlbumProgramItemBean albumProgramItemBean = new AlbumProgramItemBean(id, name, picUrl);
                    if (fee.equals("0")) {
                        list.add(albumProgramItemBean);
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    Log.d(TAG, "parseAlbumDetail: " + list.get(i).getId());
                }
                AudioPlayer.getInstance().setQueueAndIndex(list, 0);
                PlayerService.startPlayerService();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
