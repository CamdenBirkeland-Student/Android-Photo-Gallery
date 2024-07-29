package com.example.photogallery

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoAdapter(private val context: Context, private val photos: List<String>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photoUrl = photos[position]
        try {
            Glide.with(context)
                .load(photoUrl)
                .apply {
                    placeholder(android.R.drawable.progress_indeterminate_horizontal)
                    error(android.R.drawable.stat_notify_error)
                }
                .into(holder.imageView)

            Log.d("PhotoAdapter", "Loaded image: $photoUrl")
            holder.itemView.setOnClickListener {
                val intent = Intent(context, PhotoViewActivity::class.java)
                intent.putStringArrayListExtra("photoUrls", ArrayList(photos))
                intent.putExtra("position", position)
                context.startActivity(intent)
            }
        } catch (e: Exception) {
            Log.e("PhotoAdapter", "Error loading image: $photoUrl", e)
            Toast.makeText(context, "Failed to load image", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }
}