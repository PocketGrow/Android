package com.example.pocketgrow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketgrow.R

//ini masi make data local

data class NewsItem(
    val judul: String,
//    val deskripsi: String,
    val tanggal: String,
    val thumbnail: Int // Gunakan tipe data yang sesuai dengan gambar (misalnya: Int untuk resource ID)
)

class NewsAdapter(private val newsList: List<NewsItem>, private val context: Context) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem = newsList[position]

        // Set data to views
        holder.gambarThumbnail.setImageResource(newsItem.thumbnail)
        holder.namaThumbnail.text = newsItem.judul
//        holder.descThumbnail.text = newsItem.deskripsi
        holder.tanggalThumbnail.text = newsItem.tanggal
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambarThumbnail: ImageView = itemView.findViewById(R.id.gambarThumbnail)
        val namaThumbnail: TextView = itemView.findViewById(R.id.namaThumbnail)
//        val descThumbnail: TextView = itemView.findViewById(R.id.descThumbnail)
        val tanggalThumbnail: TextView = itemView.findViewById(R.id.tanggalThumbnail)
    }
}