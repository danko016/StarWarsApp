package com.example.dev.peoplestar.activity

import android.content.Context
import com.example.dev.peoplestar.adapter.ViewPagerAdapter
import com.example.dev.peoplestar.modules.DataModule
import com.example.dev.peoplestar.modules.FragmentModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dev on 29.09.16..
 */
@Singleton
@Component(modules = arrayOf(DataModule::class, FragmentModule::class))
interface MainActivityComponent{

    fun inject(context: Context)

    fun presenter(): MainActivityPresenter

    fun adapter(): ViewPagerAdapter

}