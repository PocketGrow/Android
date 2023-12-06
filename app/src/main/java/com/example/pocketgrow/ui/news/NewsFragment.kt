package com.example.pocketgrow.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketgrow.R
import com.example.pocketgrow.adapter.NewsAdapter
import com.example.pocketgrow.adapter.NewsItem

//ini ngambil datanya masi local
class NewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsList: List<NewsItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewNews)
        newsList = generateNewsItems() // Method untuk mengisi data (contoh)

        // Inisialisasi dan set adapter
        newsAdapter = NewsAdapter(newsList, requireContext())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = newsAdapter

        return view
    }

    private fun generateNewsItems(): List<NewsItem> {
        // Metode ini harus Anda sesuaikan untuk memasukkan data aktual dari sumber Anda.
        val items = mutableListOf<NewsItem>()

        // Contoh pengisian data
        items.add(NewsItem("Judul 1",  "05/12/2023", R.drawable.stock_thumbnail))
        items.add(NewsItem("Judul 2",  "05/12/2023", R.drawable.stock_thumbnail))
        items.add(NewsItem("Judul 3",  "05/12/2023", R.drawable.stock_thumbnail))
        items.add(NewsItem("Judul 4",  "05/12/2023", R.drawable.stock_thumbnail))
        items.add(NewsItem("Judul 5",  "05/12/2023", R.drawable.stock_thumbnail))
        items.add(NewsItem("Judul 6",  "05/12/2023", R.drawable.stock_thumbnail))
        items.add(NewsItem("Judul 7",  "05/12/2023", R.drawable.stock_thumbnail))
        items.add(NewsItem("Judul 8",  "05/12/2023", R.drawable.stock_thumbnail))
        // ...

        return items
    }
}