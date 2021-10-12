package com.aman.roxy.cells

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.aman.roxy.R
import com.aman.roxy.RoxyContentView
import com.aman.roxy.RoxyModelView
import com.aman.roxy.databinding.LayoutDetailsBinding
import com.aman.roxy.databinding.LayoutInterstitialBinding
import com.aman.roxy.models.Footer
import com.aman.roxy.models.Interstitial

/**
 * Created by Aman Bansal on 12/10/21.
 */


@RoxyModelView(viewType = "interstitial")
class InterstitialView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ConstraintLayout(context, attrs), RoxyContentView<Interstitial> {
    
    
    private val binding = LayoutInterstitialBinding.inflate(LayoutInflater.from(context),this)
    
    
    
    override fun bind(item: Interstitial) {
        binding.interstitial.setImageResource(item.image)
    }
    
    
}