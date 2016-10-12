package com.example.dev.peoplestar.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import javax.inject.Inject

/**
 * Created by dev on 28.06.16..
 */

open class ViewPagerAdapter
@Inject
constructor(fragmentManager: FragmentManager, val listFragment: MutableList<Fragment>) : FragmentStatePagerAdapter(fragmentManager) {

    var context: Context? = null

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence {

        when (position) {
            0 -> return "People"
            1 -> return "Planets"
            2 -> return "Starships"
        }
        return "Error"

    }


}