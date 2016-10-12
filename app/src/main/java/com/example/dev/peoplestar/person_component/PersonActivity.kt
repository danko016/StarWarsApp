package com.example.dev.peoplestar.person_component

import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.model.Person
import com.hannesdorfmann.mosby.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_person.*
import kotlinx.android.synthetic.main.activity_person_details.*
import kotlinx.android.synthetic.main.view_error.*
import kotlinx.android.synthetic.main.view_loading.*
import javax.inject.Inject

class PersonActivity
@Inject
constructor() : MvpActivity<PersonActivityView, PersonActivityPresenter>(), PersonActivityView {

    lateinit var component: PersonActivityComponent

    fun injectDependencies() {
        component = DaggerPersonActivityComponent.builder().build()
    }

    override fun createPresenter(): PersonActivityPresenter {
        return component.presenter()
    }

    override fun showError(e: Throwable?, pullToRefresh: Boolean) {
        errorView.visibility = View.VISIBLE
    }

    override fun showLoading(pullToRefresh: Boolean) {
        loadingView.visibility = View.VISIBLE
    }

    override fun loadData(pullToRefresh: Boolean) {

    }

    override fun showContent() {
        contentView.visibility = View.VISIBLE
        loadingView.visibility = View.GONE
        errorView.visibility = View.GONE
        contentView.isRefreshing = false
    }

    override fun setData(data: Person) {
        TVPersonActivityName.text = data.name
        TVPersonActivity2.text = data.gender
        TVPersonActivity3.text = data.homeworld.substringAfterLast("api/")

        if (TVPersonActivityName.text == "Luke Skywalker") {
            Glide.with(applicationContext).load(R.drawable.luke).into(IVPersonImage)
        } else {
            Glide.with(applicationContext).load(R.drawable.no_image10).override(70,70).into(IVPersonImage)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        val person: Person = intent.extras.get("person") as Person
        Log.d("tag", person.toString())
        setData(person)
    }

}
