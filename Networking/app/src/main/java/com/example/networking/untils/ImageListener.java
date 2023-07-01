package com.example.networking.untils;

import android.graphics.Bitmap;

public interface ImageListener {
    void OnImageLoaded(Bitmap bitmap);
    void OnError();
}
