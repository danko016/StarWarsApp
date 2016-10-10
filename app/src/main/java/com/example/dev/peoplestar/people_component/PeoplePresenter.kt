package com.example.dev.peoplestar.people_component

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by dev on 28.06.16..
 */

class PeoplePresenter
@Inject
constructor() : MvpBasePresenter<PeopleView>() {

    val peopleInteractor = PeopleInteractor()
    var nextPage: Int = 0


    fun loadPeople(pullToRefresh: Boolean) {
        peopleInteractor.getPeopleAsyncMethod()

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ people ->
                    view?.setData(people)
                    view?.showContent()
                    nextPage = people.getPage()

                }, { t -> view?.showError(t, pullToRefresh) })
    }

    fun loadMoreData(pullToRefresh: Boolean) {
        if (nextPage > 0) {
            peopleInteractor.getPeopleAsyncMethod(nextPage)

                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ people ->
                        view?.addData(people)
                        view?.showContent()
                        nextPage = people.getPage()

                    }, { t -> view?.showError(t, pullToRefresh) })
        }
    }

    override fun attachView(view: PeopleView?) {
        super.attachView(view)

    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
    }

    fun defaultView() {
        view?.loadDefaultState()
    }
}