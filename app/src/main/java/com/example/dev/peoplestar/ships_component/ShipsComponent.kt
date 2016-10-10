package com.example.dev.peoplestar.ships_component

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.example.dev.peoplestar.modules.AppModule
import com.example.dev.peoplestar.modules.DataModule
import com.example.dev.peoplestar.modules.LayoutModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dev on 06.10.16..
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class, LayoutModule::class))
interface ShipsComponent{

    fun inject(context: Context)

    fun presenter(): ShipsPresenter

    fun adapter(): ShipsAdapter

    fun layout(): LinearLayoutManager

}