package com.example.dev.peoplestar.people_component

import com.example.dev.peoplestar.adapter.RestAdapter
import com.example.dev.peoplestar.model.People
import rx.Observable

/**
 * Created by dev on 28.06.16..
 */
class PeopleInteractor {


    fun getPeopleAsyncMethod(page: Int): Observable<People> {    //(id: Int)
        val service = RestAdapter.getApiService
        return service.getPeople(page)
    }

    fun getPeopleAsyncMethod(): Observable<People> {
        val service = RestAdapter.getApiService
        return service.getPeople(1)
    }

}