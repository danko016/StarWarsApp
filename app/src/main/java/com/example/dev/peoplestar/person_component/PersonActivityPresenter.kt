package com.example.dev.peoplestar.person_component

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import javax.inject.Inject

/**
 * Created by dev on 11.10.16..
 */
class PersonActivityPresenter
@Inject
constructor() : MvpBasePresenter<PersonActivityView>() {


    override fun attachView(view: PersonActivityView?) {
        super.attachView(view)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
    }

}