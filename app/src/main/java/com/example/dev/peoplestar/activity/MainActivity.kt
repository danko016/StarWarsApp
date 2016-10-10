package com.example.dev.peoplestar.activity

import android.os.Bundle
import android.util.Log
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.adapter.ViewPagerAdapter
import com.example.dev.peoplestar.modules.DataModule
import com.example.dev.peoplestar.modules.FragmentModule
import com.example.dev.peoplestar.person_component.PersonEventUrl
import com.hannesdorfmann.mosby.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

class MainActivity
@Inject
constructor() : MvpActivity<MainActivityView, MainActivityPresenter>(), MainActivityView {


    lateinit var component: MainActivityComponent
    var adapter: ViewPagerAdapter? = null

    override fun createPresenter(): MainActivityPresenter {

        Log.d("tag", "create presenter activity")
        return component.presenter()
    }

    fun injectDependencies() {
        Log.d("tag", "injectDependencies")
        component = DaggerMainActivityComponent.builder()
                .dataModule(DataModule())
                .fragmentModule(FragmentModule(supportFragmentManager))
                .build()
    }

    @Subscribe
    fun onEvent(event: PersonEventUrl) {
        vpPager.currentItem = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = component.adapter()
        vpPager.adapter = adapter
        tlTabs.setupWithViewPager(vpPager)

        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}




