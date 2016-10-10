package com.example.dev.peoplestar.planets_component

import com.example.dev.peoplestar.adapter.RestAdapter
import com.example.dev.peoplestar.model.Planets
import rx.Observable

/**
 * Created by dev on 03.10.16..
 */
class PlanetsInteractor {

    fun getPlanetsAsyncMethod(page: Int): Observable<Planets> {
        val service = RestAdapter.getApiService
        return service.getPlanets(page)
    }

    fun getPlanetsAsyncMethod(): Observable<Planets> {
        return getPlanetsAsyncMethod(1)
    }
}