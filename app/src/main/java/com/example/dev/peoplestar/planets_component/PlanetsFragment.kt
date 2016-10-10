package com.example.dev.peoplestar.planets_component

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.model.Planets
import com.example.dev.peoplestar.modules.AppModule
import com.example.dev.peoplestar.modules.DataModule
import com.example.dev.peoplestar.modules.LayoutModule
import com.example.dev.peoplestar.people_component.EndlessRecyclerViewScrollListener
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment
import kotlinx.android.synthetic.main.planets_layout.*

/**
 * Created by dev on 03.10.16..
 */
class PlanetsFragment : MvpLceFragment<SwipeRefreshLayout, Planets, PlanetsView, PlanetsPresenter>(), PlanetsView, SwipeRefreshLayout.OnRefreshListener {


    lateinit var component: PlanetsComponent
    var layoutManager : LinearLayoutManager? = null
    var adapter: PlanetsAdapter? = null

    fun injectDependencies() {
        component = DaggerPlanetsComponent.builder()
                .appModule(AppModule(context))
                .layoutModule(LayoutModule(context))
                .dataModule(DataModule())
                .build()

        adapter = component.adapter()
        layoutManager = component.layout()
    }

    override fun createPresenter(): PlanetsPresenter {
        return component.presenter()
    }

    override fun setData(data: Planets) {
        loadMore(layoutManager!!)
        adapter?.planetsList?.clear()
        addData(data)
    }

    override fun addData(data: Planets) {
        adapter?.planetsList?.addAll(data.results!!)
    }

    override fun loadData(pullToRefresh: Boolean) {
        presenter.loadPlanets(pullToRefresh)
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String {
        return e?.message.toString()
    }

    override fun loadDefaultState() {
        contentView.visibility = View.VISIBLE
        errorView.visibility = View.GONE
        loadingView.visibility = View.GONE
    }

    override fun onRefresh() {
        recyclerView.clearOnScrollListeners()
        loadData(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        injectDependencies()
        return inflater?.inflate(R.layout.planets_layout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.defaultView()
        loadData(false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        contentView.setOnRefreshListener(this)
    }

    override fun showContent() {
        super.showContent()
        contentView.visibility = View.VISIBLE
        adapter?.notifyDataSetChanged()
        contentView.isRefreshing = false
    }

    override fun showError(e: Throwable?, pullToRefresh: Boolean) {
        super.showError(e, pullToRefresh)
        errorView.visibility = View.VISIBLE
    }

    override fun showLoading(pullToRefresh: Boolean) {
        super.showLoading(pullToRefresh)
        loadingView.visibility = View.VISIBLE
        errorView.visibility = View.GONE
    }

    fun loadMore(layout: LinearLayoutManager) {
        recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layout) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                presenter.loadMoreData()
                Log.d("tag", "onLoadMore planets")
            }
        })
    }


}