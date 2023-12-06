package com.example.pocketgrow.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.pocketgrow.R
import com.example.pocketgrow.helper.AuthPreference


class HomeFragment : Fragment() {

    private lateinit var welcomeText: TextView

    private lateinit var viewPager: ViewPager
    private lateinit var icLeft: ImageView
    private lateinit var icRight: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext()
        val authPreference = AuthPreference(context)
        val fullname = authPreference.getValue("fullname")

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        welcomeText = view.findViewById(R.id.welcomeText)
        // Set the welcome text
        val welcomeMessage = getString(R.string.welcome_message, fullname)
        welcomeText.text = welcomeMessage

        System.out.println(fullname)

        // Initialize ViewPager and related views
        viewPager = view.findViewById(R.id.viewPager) ?: throw IllegalStateException("ViewPager not found in the layout")
        icLeft = view.findViewById(R.id.ic_left)
        icRight = view.findViewById(R.id.ic_right)

        // Set up ViewPager adapter with your images
        val imageAdapter = ImagePagerAdapter(requireContext(),
            listOf(R.drawable.newsimghome, R.drawable.stock_thumbnail, R.drawable.ic_banner_foreground))
        viewPager.adapter = imageAdapter

        // Set click listeners for left and right icons
        icLeft.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem - 1
        }

        icRight.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem + 1
        }

        // Set click listener for "seall news" TextView
        view.findViewById<TextView>(R.id.SeeAllNews).setOnClickListener {
            // Navigate to the NewsFragment
            findNavController().navigate(R.id.navigation_news)
        }
        return view
    }



    companion object {
    }
}