package com.aman.roxy.models

import com.aman.roxy.RoxyItem

/**
 * Created by Aman Bansal on 12/10/21.
 */


data class Interstitial(
    val image: Int,
    val tp: String
) : RoxyItem {
    override fun getType(): String {
        return tp
    }
}