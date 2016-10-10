package com.example.dev.peoplestar.modules

import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides

/**
 * Created by dev on 28.06.16..
 */
@Module
class FragmentModule(val fragmentManager: FragmentManager) {

    @Provides
    fun providesFragmentManager():FragmentManager {
        return fragmentManager
    }

}