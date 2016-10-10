package com.example.dev.peoplestar.planets_component

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by dev on 03.10.16..
 */

class PlanetsPresenter
@Inject
constructor() : MvpBasePresenter<PlanetsView>() {

    val planetsInteractor = PlanetsInteractor()
    var nextPage: Int = 0

    fun loadPlanets(pullToRefresh: Boolean) {
        planetsInteractor.getPlanetsAsyncMethod()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { planets ->
                            view?.setData(planets)
                            view?.showContent()
                            nextPage = planets.getPage()
                        },
                        { t ->
                            view?.showError(t, pullToRefresh)
                        }
                )
    }


    fun loadMoreData() {
        if (nextPage > 0) {
            planetsInteractor.getPlanetsAsyncMethod(nextPage)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { planets ->
                                view?.addData(planets)
                                view?.showContent()
                                nextPage = planets.getPage()
                            },
                            { t ->
                                view?.showError(t, false)
                            }
                    )
        }
    }

    override fun attachView(view: PlanetsView?) {
        super.attachView(view)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
    }

    fun defaultView() {
        view?.loadDefaultState()
    }


}