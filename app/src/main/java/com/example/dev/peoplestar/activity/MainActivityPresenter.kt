package com.example.dev.peoplestar.activity

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import javax.inject.Inject

/**
 * Created by dev on 29.09.16..
 */
class MainActivityPresenter
@Inject
constructor(): MvpBasePresenter<MainActivityView>() {

    override fun attachView(view: MainActivityView?) {
        super.attachView(view)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
    }


}