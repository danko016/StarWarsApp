package com.example.dev.peoplestar.people_component

import com.example.dev.peoplestar.adapter.RestAdapter
import com.example.dev.peoplestar.model.Person
import rx.Observable

/**
 * Created by dev on 28.06.16..
 */
class PersonInteractor {


    fun getPersonAsyncMethod(id: Int): Observable<Person> {    //(id: Int)

        val service = RestAdapter.getApiService
        return service.getPerson(id)
    }
}