package com.cgtrc.bym.mycodinglib.imageloader;

import android.graphics.Bitmap;

/**
 * Created by bym on 16/4/10.
 */
public class DoubleCache implements ImageCache {
    private ImageCache mMemoryCache = new MemoryCache();
    private ImageCache mDiskCache = new DiskCache();

    //先从缓存中获取图片.如果没有,再从SD卡中获取
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if(bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }
    //将图片缓存到内存和SD卡中
    @Override
    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url,bmp);
        mDiskCache.put(url,bmp);
    }
}
