package com.aman.roxy

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * This internal Recyclerview adapter for RoxyView
 */

internal class RoxyAdapter(
    private var list: List<RoxyItem>,
    private val typeViewClassMap: HashMap<String, Class<out RoxyContentView<*>>>

) : RecyclerView.Adapter<RoxyAdapter.RoxyViewHolder>() {
    
    private var typeMap = HashMap<String, Int>()
    
    private var viewTypeMap = HashMap<Int, String>()
    
    private var viewTypeCount = 0
    
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoxyViewHolder {
        val type = viewTypeMap[viewType]
        val clazz = typeViewClassMap[type] ?: throw Exception("No type View class found for viewType $type")
        
        return if (type != null) {
            
            val view = buildView(parent.context, clazz)
            
            if (view == null) {
                throw IllegalStateException("RoxyContentView is null for type $type")
            }
            
            if (view is View) {
                RoxyViewHolder(view)
            } else {
                throw IllegalStateException("view should be a parent of View class")
            }
            
        } else {
            
            RoxyViewHolder(View(parent.context))
            
        }
    }
    
    override fun onBindViewHolder(holder: RoxyViewHolder, position: Int) {
        holder.bind(list[position])
    }
    
    override fun getItemViewType(position: Int): Int {
        val type = list[position].getType()
        
        val viewType = typeMap[type]
        
        return if (viewType == null) {
            
            typeMap[type] = ++viewTypeCount
            
            viewTypeMap[viewTypeCount] = type
            
            viewTypeCount
        } else {
            viewType
        }
    }
    
    private fun buildView(
        context: Context,
        clazz: Class<out RoxyContentView<*>>
    ): RoxyContentView<*> {
        val con = clazz.getConstructor(Context::class.java)
        return con.newInstance(context)
    }
    
    
    override fun getItemCount() = list.size
    
    
    
    fun setList(list: List<RoxyItem>) {
        this.list = list
        notifyDataSetChanged()
    }
    
    inner class RoxyViewHolder(private val contentView: View) :
        RecyclerView.ViewHolder(contentView) {
        
        init {
            contentView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        
        fun bind(item: RoxyItem) {
            
            if (contentView is RoxyContentView<*>) {
                
                (contentView as? RoxyContentView<RoxyItem>)?.bindItem(item)
            }
            
        }
    }
    
}

