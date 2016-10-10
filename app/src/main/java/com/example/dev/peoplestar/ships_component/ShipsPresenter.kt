package com.example.dev.peoplestar.ships_component

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by dev on 06.10.16..
 */
class ShipsPresenter
@Inject
constructor() : MvpBasePresenter<ShipsView>() {


    val shipInteractor = ShipsInteractor()
    var nextPage: Int = 0

    fun loadShips(pullToRefresh: Boolean) {

        shipInteractor.getShipsAsyncMethod()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { ships ->
                            view?.setData(ships)
                            view?.showContent()
                            nextPage = ships.getPage()
                        },
                        {
                            t ->
                            view?.showError(t, pullToRefresh)
                        }
                )
    }

    fun loadMoreData() {
        if (nextPage > 0) {
            shipInteractor.getShipsAsyncMethod(nextPage)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { ships ->
                                view?.addData(ships)
                                view?.showContent()
                                nextPage = ships.getPage()
                            },
                            {
                                t ->
                                view?.showError(t, false)
                            }
                    )
        }
    }

    override fun attachView(view: ShipsView?) {
        super.attachView(view)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
    }

    fun defaultView() {
        view?.loadDefaultState()
    }

}