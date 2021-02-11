package com.example.firstlesson.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.firstlesson.R
import com.example.firstlesson.async_class.AsyncClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.util.*

class GalleryAdapter(var pictureUrlList: ArrayList<String>) : RecyclerView.Adapter<GalleryAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var progressBar: ProgressBar

        init {
            img = itemView.findViewById(R.id.imageView)
            progressBar = itemView.findViewById(R.id.progressBar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.picture_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val asyncTask = AsyncClass(holder.img, holder.progressBar)
//        asyncTask.execute(pictureUrlList.get(position))

        CoroutineScope(Dispatchers.IO).launch {
            var bit: Bitmap? = null
            try {
                val picUrl = URL(pictureUrlList[0]).openStream()
                bit = BitmapFactory.decodeStream(picUrl)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            withContext(Dispatchers.Main) {
                holder.img.setImageBitmap(bit)
                holder.img.visibility = View.VISIBLE
                holder.progressBar.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return pictureUrlList.size
    }
}