package com.example.dev.peoplestar.modules

import android.support.v4.app.Fragment
import com.example.dev.peoplestar.Ship
import com.example.dev.peoplestar.model.Person
import com.example.dev.peoplestar.model.Planet
import com.example.dev.peoplestar.people_component.PeopleFragment
import com.example.dev.peoplestar.planets_component.PlanetsFragment
import com.example.dev.peoplestar.ships_component.ShipsFragment
import dagger.Module
import dagger.Provides
import java.util.*

/**
 * Created by dev on 29.09.16..
 */
@Module
class DataModule() {

    @Provides
    fun providesData(): MutableList<Person>{
        return ArrayList()
    }

    @Provides
    fun providesPlanetsData(): MutableList<Planet>{
        return ArrayList()
    }

    @Provides
    fun providesShipsData(): MutableList<Ship>{
        return ArrayList()
    }

    @Provides
    fun provideListFragment(): List<Fragment> {
        val list: List<Fragment> = listOf(PeopleFragment(), PlanetsFragment(), ShipsFragment())
        return list
    }

}