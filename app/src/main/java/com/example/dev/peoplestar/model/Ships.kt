package com.example.dev.peoplestar.model

import com.example.dev.peoplestar.Ship

/**
 * Created by dev on 06.10.16..
 */
class Ships {

    var results: List<Ship>? = null
    var next: String? = null

    fun getPage(): Int {
        var page = 0
        if (next != null) {
            page = next?.substringAfterLast("=")!!.toInt()
        }

        return page
    }
}