package com.example.dev.peoplestar.person_component

import android.util.Log
import com.example.dev.peoplestar.people_component.PersonInteractor
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by dev on 29.06.16..
 */

class PersonPresenter
@Inject
constructor() : MvpBasePresenter<PersonView>() {

    val personInteractor = PersonInteractor()
    var id: Int = 0

    @Subscribe
    fun onEvent(event: PersonEventUrl) {
         id = event.id
        Log.d("tag", "eventbus catch")
        view?.loadData(true)
    }

    fun loadPerson(pullToRefresh: Boolean) {
        Log.d("tag", "loadperson in presenter")
        personInteractor.getPersonAsyncMethod(id)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ person ->
                    Log.d("tag", "before set data")
                    view?.setData(person)

                    view?.showContent()

                }, { t -> view?.showError(t, pullToRefresh) })
    }

    override fun attachView(view: PersonView?) {
        super.attachView(view)
        EventBus.getDefault().register(this)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        EventBus.getDefault().unregister(this)
    }

}



