package com.example.dev.peoplestar.model

/**
 * Created by dev on 30.06.16..
 */
class Planets {
    var results: List<Planet>? = null
    var next: String? = null

    fun getPage(): Int {
        var page = 0

        try {
            if (next?.isNotEmpty()!!) {
                page = next?.substringAfterLast("=")!!.toInt()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


        return page
    }
}