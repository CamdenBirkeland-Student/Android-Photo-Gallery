package com.example.photogallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide

class PhotoViewPagerAdapter(private val context: Context, private val photoUrls: List<String>) : PagerAdapter() {

    override fun getCount(): Int {
        return photoUrls.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_photo_view, container, false)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        Glide.with(context)
            .load(photoUrls[position])
            .into(imageView)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}