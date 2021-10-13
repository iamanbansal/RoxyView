package com.aman.roxy

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Aman Bansal on 11/10/21.
 *
 * This is RecyclerView subclass.
 * This can be used in the xml
 */
class RoxyView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    RecyclerView(context, attrs) {
    
    
    private var roxyAdapter: RoxyAdapter? = null
    
    /**
     * This method to prepare and build Recyclerview.
     *
     * @param classList this is list of class of ItemViews sublcass of RoxyContentView
     *
     * @param itemList this is list of data to be rendered, it can avoided at the time of building.
     * Use #setList to pass new list.
     */
    
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
    
    /**
     * This message should be called to update the list items.
     * #build() method should be called before calling #setList()
     */
    
    
    fun setList(list: List<RoxyItem>) {
        if (roxyAdapter == null) {
            throw IllegalStateException("RoxyView hasn't built yet. Call build method before calling setList")
        }
        
        roxyAdapter?.setList(list)
    }
}
