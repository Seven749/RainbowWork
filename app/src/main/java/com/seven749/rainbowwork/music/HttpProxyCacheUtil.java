package com.seven749.rainbowwork.music;

import com.danikula.videocache.HttpProxyCacheServer;
import com.seven749.rainbowwork.App;

import static android.os.Environment.DIRECTORY_MUSIC;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class HttpProxyCacheUtil {

    private static HttpProxyCacheServer audioProxy;

    public static HttpProxyCacheServer getAudioProxy() {
        if (audioProxy== null) {
            audioProxy= new HttpProxyCacheServer.Builder(App.getInstance())
                    .cacheDirectory(CachesUtil.getMediaCacheFile(DIRECTORY_MUSIC))
                    .maxCacheSize(1024 * 1024 * 1024) // 缓存大小
                    .fileNameGenerator(new CacheFileNameGenerator())
                    .build();
        }
        return audioProxy;
    }
}
