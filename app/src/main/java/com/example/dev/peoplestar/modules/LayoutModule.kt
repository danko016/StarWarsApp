package com.example.dev.peoplestar.modules

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides

/**
 * Created by dev on 09.10.16..
 */
@Module
class LayoutModule(val context: Context){

    @Provides
    fun providesLayout(): LinearLayoutManager{
        return LinearLayoutManager(context)
    }

}