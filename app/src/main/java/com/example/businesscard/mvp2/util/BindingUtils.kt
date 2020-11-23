package com.example.businesscard.mvp2.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingUtils{
    companion object {
        @BindingAdapter("avatarUrls")
        @JvmStatic
        fun setAvatarUrls(imageView: ImageView, url: String) {
            Glide.with(imageView)
                .load(url)
                .centerCrop()
                .into(imageView)
        }
    }
}