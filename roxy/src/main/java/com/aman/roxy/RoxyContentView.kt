package com.aman.roxy




interface RoxyContentView<T: RoxyItem> {
    
    fun bindItem(item: RoxyItem){
    
        bind(item as T)
    }
    
    fun bind(item: T)
}
