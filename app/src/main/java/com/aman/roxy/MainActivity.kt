package com.aman.roxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aman.roxy.cells.DetailsView
import com.aman.roxy.cells.FooterView
import com.aman.roxy.cells.HeaderView
import com.aman.roxy.cells.InterstitialView
import com.aman.roxy.databinding.ActivityMainBinding
import com.aman.roxy.models.Details
import com.aman.roxy.models.Footer
import com.aman.roxy.models.Header
import com.aman.roxy.models.Interstitial



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        
        binding.roxyView.build(
            arrayListOf(
                HeaderView::class.java,
                FooterView::class.java,
                InterstitialView::class.java,
                DetailsView::class.java
            )
        )
        
        binding.roxyView.setList(arrayListOf(
            Header("Luxury Vila with pool", "Gurgaon, Haryana", R.drawable.house, "header"),
            Details("Description", "Perfect, poised and pristine. Newly build for 2021 and designed by one of the top Gurgoan's Real estate\nLiving room, 2 Bed rooms,Kitchen\n Call: 999993333", "details"),
            Interstitial(R.drawable.interstitial, "interstitial"),
            Footer("$10000", "Buy now", "footer")
        ))
        
    }
}