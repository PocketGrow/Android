package com.example.pocketgrow.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.pocketgrow.R

class ImagePagerAdapter(private val context: Context, private val images: List<Int>) : PagerAdapter() {
    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_viewpager, container, false)

        // ImageView
        val imageView: ImageView = layout.findViewById(R.id.imageView)
        imageView.setImageResource(images[position])

        // TextView (Judul)
        val titleTextView: TextView = layout.findViewById(R.id.titleNews)
        titleTextView.text = "Judul ${position + 1}" // Judul

        container.addView(layout)
        return layout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}