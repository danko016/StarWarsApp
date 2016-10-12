package com.example.dev.peoplestar.person_component

import com.example.dev.peoplestar.adapter.RestAdapter
import com.example.dev.peoplestar.model.Person
import rx.Observable

/**
 * Created by dev on 11.10.16..
 */
class PersonInteractor{

    fun getPersonAsyncMethod(id: Int): Observable<Person>{
        val service =  RestAdapter.getApiService
        return service.getPerson(id)
    }

}