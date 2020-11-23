package com.example.businesscard.mvvm1.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingUtil {
    companion object {
        @BindingAdapter("avatarUrl")
        @JvmStatic
        fun setAvatarUrl(imageView: ImageView, url: String?) {
            Glide.with(imageView)
                .load(url)
                .centerCrop()
                .into(imageView)
        }
    }
}