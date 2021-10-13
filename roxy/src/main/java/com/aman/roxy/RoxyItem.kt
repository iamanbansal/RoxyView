package com.aman.roxy

/**
 * Created by Aman Bansal on 11/10/21.
 *
 * This interface has to be implemented by data class return the type
 * which is same as mentioned here {@link com.aman.roxy.RoxyModelView}
 *
 * Type will decide will ItemView to render bases on the annotation.
 */
interface RoxyItem {
    fun getType():String
}