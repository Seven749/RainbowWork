package com.seven749.rainbowwork.music;

import android.os.Environment;
import android.util.Log;

import com.seven749.rainbowwork.App;

import java.io.File;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class CachesUtil {

    private static final String TAG = "CachesUtil";
    public static String VIDEO = "video";

    /**
     * 获取媒体缓存文件
     *
     * @param child
     * @return
     */
    public static File getMediaCacheFile(String child) {
        String directoryPath = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // 外部储存可用
            directoryPath = App.getInstance().getExternalFilesDir(child).getAbsolutePath();
        } else {
            directoryPath = App.getInstance().getFilesDir().getAbsolutePath() + File.separator + child;
        }
        File file = new File(directoryPath);
        //判断文件目录是否存在
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.d(TAG, "getMediaCacheFile ====> " + directoryPath);
        return file;
    }
}
