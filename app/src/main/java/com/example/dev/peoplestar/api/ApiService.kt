package com.example.dev.peoplestar.api

import com.example.dev.peoplestar.model.People
import com.example.dev.peoplestar.model.Person
import com.example.dev.peoplestar.model.Planets
import com.example.dev.peoplestar.model.Ships
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by dev on 28.06.16..
 */

interface ApiService {
    @GET("/api/people/")
    fun getPeople(@Query("page") page: Int): Observable<People>

    @GET("/api/people/{personId}")
    fun getPerson(@Path("personId") id: Int): Observable<Person>

    @GET("/api/planets/")
    fun getPlanets(@Query("page") page: Int): Observable<Planets>

    @GET("/api/starships/")
    fun getShips(@Query("page") page: Int): Observable<Ships>


}
