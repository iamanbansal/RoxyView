package com.aman.roxy

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Aman Bansal on 11/10/21.
 */
class RoxyView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    RecyclerView(context, attrs) {
    
    
    private var roxyAdapter: RoxyAdapter? = null
    
    
    fun build(classList: List<Class<out RoxyContentView<*>>>, itemList: List<RoxyItem> = listOf()) {
        
        val typeViewMap = HashMap<String, Class<out RoxyContentView<*>>>()
        classList.forEach {
            
            val ann = it.getAnnotation(RoxyModelView::class.java)
            
            if (ann == null) throw Exception("$it does not have RoxyModelView annotation ")
            
            if (ann.viewType.isBlank()) throw Exception("RoxyModelView requires viewType for $it")
            
            typeViewMap[ann.viewType] = it
        }
        
        roxyAdapter = RoxyAdapter(itemList, typeViewMap)
        adapter = roxyAdapter
    }
    
    
    
    fun setList(list: List<RoxyItem>) {
        if (roxyAdapter == null) {
            throw IllegalStateException("RoxyView hasn't built yet. Call build method before calling setList")
        }
        
        roxyAdapter?.setList(list)
    }
}
