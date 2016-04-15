package com.cgtrc.bym.mycodinglib.imageloader;

import android.graphics.Bitmap;

/**
 * Created by bym on 16/4/10.
 */
public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url, Bitmap bmp);
}
