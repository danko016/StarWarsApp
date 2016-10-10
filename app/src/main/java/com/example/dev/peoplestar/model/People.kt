package com.example.dev.peoplestar.model

/**
 * Created by dev on 28.06.16..
 */
class People {
    var results: List<Person>? = null
    var next: String? = null

    fun getPeopleResult(): List<Person>? {
        return results
    }

    fun getPage(): Int{
        var page = 0
        if (next != null){
            page = next?.substringAfterLast("=")!!.toInt()
        }
        return page
    }



}