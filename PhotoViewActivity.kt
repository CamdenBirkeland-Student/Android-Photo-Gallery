package com.example.photogallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class PhotoViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_view)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val photoUrls = intent.getStringArrayListExtra("photoUrls") ?: arrayListOf()
        val initialPosition = intent.getIntExtra("position", 0)

        val adapter = PhotoViewPagerAdapter(this, photoUrls)
        viewPager.adapter = adapter
        viewPager.currentItem = initialPosition
    }
}