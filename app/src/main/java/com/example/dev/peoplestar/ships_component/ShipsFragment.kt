package com.example.dev.peoplestar.ships_component

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.model.Ships
import com.example.dev.peoplestar.modules.AppModule
import com.example.dev.peoplestar.modules.DataModule
import com.example.dev.peoplestar.modules.LayoutModule
import com.example.dev.peoplestar.people_component.EndlessRecyclerViewScrollListener
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment
import kotlinx.android.synthetic.main.ships_layout.*

/**
 * Created by dev on 06.10.16..
 */
class ShipsFragment : MvpLceFragment<SwipeRefreshLayout, Ships, ShipsView, ShipsPresenter>(), ShipsView, SwipeRefreshLayout.OnRefreshListener {


    lateinit var component: ShipsComponent
    var adapter: ShipsAdapter? = null
    var layoutManager: LinearLayoutManager? = null

    fun injectDependencies() {
        component = DaggerShipsComponent.builder()
                .appModule(AppModule(context))
                .dataModule(DataModule())
                .layoutModule(LayoutModule(context))
                .build()

        adapter = component.adapter()
        layoutManager = component.layout()
    }

    override fun setData(data: Ships) {
        loadMore(layoutManager!!)
        adapter?.shipsList?.clear()
        addData(data)
    }

    override fun addData(data: Ships) {
        adapter?.shipsList?.addAll(data.results!!)
    }

    override fun loadData(pullToRefresh: Boolean) {
        presenter.loadShips(pullToRefresh)
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String {
        return e?.message.toString()
    }

    override fun createPresenter(): ShipsPresenter {
        return component.presenter()
    }

    override fun loadDefaultState() {
        contentView.visibility = View.VISIBLE
        errorView.visibility = View.GONE
        loadingView.visibility = View.GONE
    }

    override fun onRefresh() {
        recyclerView.clearOnScrollListeners()
        loadData(false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData(false)
        presenter.defaultView()
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        contentView.setOnRefreshListener(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        injectDependencies()
        return inflater?.inflate(R.layout.ships_layout, container, false)
    }

    override fun showContent() {
        super.showContent()
        contentView.visibility = View.VISIBLE
        adapter?.notifyDataSetChanged()
        contentView.isRefreshing = false
    }

    override fun showLoading(pullToRefresh: Boolean) {
        super.showLoading(pullToRefresh)
        loadingView.visibility = View.VISIBLE
        contentView.visibility = View.GONE
    }

    override fun showError(e: Throwable?, pullToRefresh: Boolean) {
        super.showError(e, pullToRefresh)
        errorView.visibility = View.VISIBLE
        contentView.visibility = View.GONE
    }

    fun loadMore(layout: LinearLayoutManager){
        recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layout){
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                presenter.loadMoreData()
            }

        })
    }


}