package com.example.dev.peoplestar.people_component

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.model.People
import com.example.dev.peoplestar.modules.AppModule
import com.example.dev.peoplestar.modules.DataModule
import com.example.dev.peoplestar.modules.LayoutModule
import com.example.dev.peoplestar.person_component.PersonActivity
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment
import kotlinx.android.synthetic.main.people_layout.*

/**
 * Created by dev on 28.06.16..
 */

class PeopleFragment() : MvpLceFragment<SwipeRefreshLayout, People, PeopleView, PeoplePresenter>(), PeopleView, SwipeRefreshLayout.OnRefreshListener {



    lateinit var component: PeopleComponent
    var adapter: PeopleAdapter? = null
    var layoutManager : LinearLayoutManager? = null

    override fun loadDefaultState() {
        contentView.visibility = View.VISIBLE
        errorView.visibility = View.GONE
        loadingView.visibility = View.GONE
    }

    fun injectDependencies() {
        component = DaggerPeopleComponent.builder()
                .appModule(AppModule(context))
                .layoutModule(LayoutModule(context))
                .dataModule(DataModule())
                .build()
        adapter = component.adapter()
        layoutManager = component.layout()
    }

    override fun setData(data: People) {
        loadMore(layoutManager!!)
        adapter?.peopleList?.clear()
        addData(data)
    }

    override fun addData(data: People) {
        adapter?.peopleList?.addAll(data.getPeopleResult()!!)
    }

    override fun openPersonActivity(position: Int) {
        val person = adapter?.peopleList!![position]
        val intent: Intent = Intent(context, PersonActivity::class.java)
        intent.putExtra("person", person)
        context.startActivity(intent)
    }

    override fun onRefresh() {
        recyclerView.clearOnScrollListeners()
        loadData(true)
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String? {
        return e?.message
    }

    override fun loadData(pullToRefresh: Boolean) {
        presenter.loadPeople(pullToRefresh)
    }

    override fun showContent() {
        super.showContent()
        adapter?.notifyDataSetChanged()
        contentView.visibility = View.VISIBLE
        contentView.isRefreshing = false
    }

    override fun showError(e: Throwable?, pullToRefresh: Boolean) {
        super.showError(e, pullToRefresh)
        errorView.text = e?.message
        contentView.isRefreshing = false
        errorView.visibility = View.VISIBLE
        loadingView.visibility = View.GONE
    }

    override fun showLoading(pullToRefresh: Boolean) {
        super.showLoading(pullToRefresh)
        loadingView.visibility = View.VISIBLE
    }

    override fun createPresenter(): PeoplePresenter {
        return component.presenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        injectDependencies()
        return inflater?.inflate(R.layout.people_layout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.defaultView()
        loadData(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        contentView.setOnRefreshListener(this)
    }

    override fun loadMore(layout: LinearLayoutManager) {
        recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layout) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                Log.d("tag", "onLoadMore")
                presenter.loadMoreData(false)
            }

        })
    }


}



