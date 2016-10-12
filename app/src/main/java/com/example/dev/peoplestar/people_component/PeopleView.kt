package com.example.dev.peoplestar.people_component

import android.support.v7.widget.LinearLayoutManager
import com.example.dev.peoplestar.model.People
import com.hannesdorfmann.mosby.mvp.MvpView
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView

/**
 * Created by dev on 28.06.16..
 */
interface PeopleView : MvpView, MvpLceView<People> {

    fun loadDefaultState()

    fun loadMore(layout: LinearLayoutManager)

    fun addData(data: People)

    fun openPersonActivity(position: Int)

}