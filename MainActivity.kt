package com.example.photogallery

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoAdapter
    private var photoUrls: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        setContentView(R.layout.activity_main)

        try {
            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = GridLayoutManager(this, 3)
            loadPhotos()
        } catch (e: Exception) {
            Log.e("MainActivity", "Error during onCreate", e)
        }
    }

    private fun loadPhotos() {
        Log.d("MainActivity", "loadPhotos called")
        // Example direct URLs from Imgur
        photoUrls.add("https://i.imgur.com/CYhkVpG.jpeg")
        photoUrls.add("https://i.imgur.com/V1M7hHU.jpeg")
        photoUrls.add("https://i.imgur.com/TvtkkWq.jpeg")
        photoUrls.add("https://i.imgur.com/YiVbbLn.jpeg")
        photoUrls.add("https://i.imgur.com/2BHML6y.jpeg")
        // Add more URLs or fetch them dynamically

        try {
            runOnUiThread {
                photoAdapter = PhotoAdapter(this, photoUrls)
                recyclerView.adapter = photoAdapter
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error during loadPhotos", e)
        }
    }
}