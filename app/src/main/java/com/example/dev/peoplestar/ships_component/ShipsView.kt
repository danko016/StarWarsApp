package com.example.dev.peoplestar.ships_component

import com.example.dev.peoplestar.model.Ships
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView

/**
 * Created by dev on 06.10.16..
 */
interface ShipsView: MvpLceView<Ships>{

    fun loadDefaultState()

    fun addData(data: Ships)

}