package com.aman.roxy


/**
 * This interface should be the implemented by ItemView class and DataClass should be passed with
 * which you want to bind it.
 *
 */


interface RoxyContentView<T: RoxyItem> {
    
    fun bindItem(item: RoxyItem){
    
        bind(item as T)
    }
    
    
    /**
     *
     * This method will be called at the time of rendering and data item will be passed.
     */
    fun bind(item: T)
}
