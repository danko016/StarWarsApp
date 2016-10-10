package com.example.dev.peoplestar.ships_component

import com.example.dev.peoplestar.adapter.RestAdapter
import com.example.dev.peoplestar.model.Ships
import rx.Observable

/**
 * Created by dev on 06.10.16..
 */
class ShipsInteractor{

    fun getShipsAsyncMethod() : Observable<Ships>{
        val service = RestAdapter.getApiService
        return service.getShips(1)
    }

    fun getShipsAsyncMethod(page: Int) : Observable<Ships>{
        val service = RestAdapter.getApiService
        return service.getShips(page)
    }

}