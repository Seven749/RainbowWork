package com.seven749.rainbowwork.utils.normal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

/**
 * @author 行云流水
 * @date 2020/4/28
 * @description 转Bitmap
 */
public class ToBitmap {
    private ToBitmap() {};

    // 文件转Bitmap
    Bitmap get(File param) {
        Bitmap bitmap = BitmapFactory.decodeFile(param.getPath());
        return bitmap;
    }

    // drawable转Bitmap
    Bitmap get(Resources resources, int id) {
        Bitmap bitmap = BitmapFactory.decodeResource(resources, id);
        return bitmap;
    }
}
