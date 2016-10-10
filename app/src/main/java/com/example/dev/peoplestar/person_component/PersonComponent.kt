package com.example.dev.peoplestar.person_component

import android.content.Context
import com.example.dev.peoplestar.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dev on 29.06.16..
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface PersonComponent {
    fun inject(context: Context)

    fun presenter(): PersonPresenter
}