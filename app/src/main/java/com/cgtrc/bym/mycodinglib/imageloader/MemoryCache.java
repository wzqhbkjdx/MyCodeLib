package com.cgtrc.bym.mycodinglib.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by bym on 16/4/10.
 */
public class MemoryCache implements ImageCache {
    //图片缓存
    LruCache<String,Bitmap> mImageCache;
    //线程池,数量为CPU的数量


    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache() {
        //计算可使用的最大内存
        final int maxMemary = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取1/4的可用内存作为缓存
        final int cacheSize = maxMemary / 4;
        mImageCache = new LruCache<String,Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url,bitmap);
    }
    public Bitmap get(String url) {
        return mImageCache.get(url);
    }
}
