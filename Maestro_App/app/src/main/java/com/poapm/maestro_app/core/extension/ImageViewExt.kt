package com.poapm.maestro_app.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.poapm.maestro_app.R

@BindingAdapter("loadFromURLCircular")
fun ImageView.loadFromURLCircular(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_class)
    transformations(CircleCropTransformation())
}

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_class)
    transformations(RoundedCornersTransformation(25.2F))
}

@BindingAdapter("loadFromUrl2")
fun ImageView.loadFromURL2(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_class)
}