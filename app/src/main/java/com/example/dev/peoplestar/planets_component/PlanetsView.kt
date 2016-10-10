package com.example.dev.peoplestar.planets_component

import com.example.dev.peoplestar.model.Planets
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView

/**
 * Created by dev on 03.10.16..
 */
interface PlanetsView: MvpLceView<Planets>{

    fun loadDefaultState()

    fun addData(data: Planets)

}