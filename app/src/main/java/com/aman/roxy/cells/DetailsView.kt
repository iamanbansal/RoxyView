package com.aman.roxy.cells

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.aman.roxy.R
import com.aman.roxy.RoxyContentView
import com.aman.roxy.RoxyModelView
import com.aman.roxy.databinding.LayoutDetailsBinding
import com.aman.roxy.models.Details
import com.aman.roxy.models.Header

/**
 * Created by Aman Bansal on 12/10/21.
 */


@RoxyModelView(viewType = "details")
class DetailsView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs), RoxyContentView<Details> {
    
    
    var  binding:LayoutDetailsBinding = LayoutDetailsBinding.inflate(LayoutInflater.from(context),this)
    
    init {
        orientation = VERTICAL
    }
    
    override fun bind(item: Details) {
        
        binding.tvDescTitle.text = item.title
        binding.tvDescription.text = item.subtitle
    }
    
    
}