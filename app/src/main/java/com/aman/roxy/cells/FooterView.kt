package com.aman.roxy.cells

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.aman.roxy.R
import com.aman.roxy.RoxyContentView
import com.aman.roxy.RoxyModelView
import com.aman.roxy.databinding.LayoutCtaBinding
import com.aman.roxy.databinding.LayoutDetailsBinding
import com.aman.roxy.models.Footer

/**
 * Created by Aman Bansal on 12/10/21.
 */


@RoxyModelView(viewType = "footer")
class FooterView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ConstraintLayout(context, attrs), RoxyContentView<Footer> {
    
    
    private val binding  = LayoutCtaBinding.inflate(LayoutInflater.from(context),this)
    
    
    override fun bind(item: Footer) {
    
        binding.amount.text = item.price
        binding.btnCta.text = item.ctaText
    }
    
    
}