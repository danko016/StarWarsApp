package com.example.dev.peoplestar.person_component

import com.example.dev.peoplestar.model.Person
import com.hannesdorfmann.mosby.mvp.MvpView
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView

/**
 * Created by dev on 29.06.16..
 */
interface PersonView : MvpView, MvpLceView<Person> {

    //fun loadDefaultState()

}