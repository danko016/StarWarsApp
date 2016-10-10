package com.example.dev.peoplestar.person_component

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.person_component.PersonAdapter
import com.example.dev.peoplestar.model.Person
import com.example.dev.peoplestar.modules.AppModule
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment
import kotlinx.android.synthetic.main.people_layout.*
import java.util.*

/**
 * Created by dev on 28.06.16..
 */

class PersonFragment() : MvpLceFragment<SwipeRefreshLayout, Person, PersonView, PersonPresenter>(), PersonView, SwipeRefreshLayout.OnRefreshListener {


    override fun setData(data: Person) {
        Log.d("tag", "person setdata")
        this.data.clear()
        this.data.add(data)

    }


    lateinit var component: PersonComponent
    var data: MutableList<Person> = ArrayList()
    var adapter: PersonAdapter? = null

    fun injectdependencies() {

        component = DaggerPersonComponent.builder().appModule(AppModule(context)).build()

    }

    override fun createPresenter(): PersonPresenter {
        return component.presenter()
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String? {
        return null
    }

    override fun loadData(pullToRefresh: Boolean) {
        Log.d("tag", "load data before presenter")
        presenter.loadPerson(pullToRefresh)

    }

    override fun onRefresh() {

        contentView.setRefreshing(false)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        injectdependencies()

        return inflater?.inflate(R.layout.person_layout, container, false)

    }

    override fun showLoading(pullToRefresh: Boolean) {

        super.showLoading(pullToRefresh)
        loadingView.visibility = View.GONE
    }

    override fun showError(e: Throwable?, pullToRefresh: Boolean) {

        super.showError(e, pullToRefresh)
    }

    override fun showContent() {

        super.showContent()

        Log.d("tag", "show content person")
        adapter?.notifyDataSetChanged()
        contentView.setRefreshing(false)
        loadingView.visibility = View.GONE
        errorView.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        Log.d("tag", "onresume person")
        loadingView.visibility = View.GONE
        adapter = PersonAdapter(data)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.adapter = adapter
        contentView.setOnRefreshListener(this)


    }

}
