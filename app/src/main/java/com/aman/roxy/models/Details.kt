package com.aman.roxy.models

import com.aman.roxy.RoxyItem

/**
 * Created by Aman Bansal on 12/10/21.
 */


data class Details(
    val title: String,
    val subtitle: String,
    val tp: String
) : RoxyItem {
    override fun getType(): String {
        return tp
    }
}