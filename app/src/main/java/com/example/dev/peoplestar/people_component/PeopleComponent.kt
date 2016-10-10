package com.example.dev.peoplestar.people_component

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.example.dev.peoplestar.modules.AppModule
import com.example.dev.peoplestar.modules.DataModule
import com.example.dev.peoplestar.modules.LayoutModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dev on 28.06.16..
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class, LayoutModule::class))
interface PeopleComponent {

    fun inject(context: Context)

    fun presenter(): PeoplePresenter

    fun adapter(): PeopleAdapter

    fun layout(): LinearLayoutManager
}