package com.example.dev.peoplestar.planets_component

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.model.Planet
import javax.inject.Inject

/**
 * Created by dev on 03.10.16..
 */
class PlanetsAdapter
@Inject
constructor(val context: Context, val planetsList: MutableList<Planet>) : RecyclerView.Adapter<PlanetsAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlanetsAdapter.MoviesViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.planets_list, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlanetsAdapter.MoviesViewHolder?, position: Int) {
        val movies = planetsList[position]
        holder?.firstTextView?.text = movies.name
        holder?.secondTextView?.text = movies.diameter

        if (holder?.firstTextView?.text?.contains("Alderaan")!!) {
            Glide.with(context).load(R.drawable.alderan).centerCrop().into(holder?.imagePlanets)
        } else if (holder?.firstTextView?.text?.contains("Yavin")!!) {
            Glide.with(context).load(R.drawable.yavin).centerCrop().into(holder?.imagePlanets)
        } else if (holder?.firstTextView?.text == "Dagobah") {
            Glide.with(context).load(R.drawable.dagobah).into(holder?.imagePlanets)
        } else if (holder?.firstTextView?.text == "Bespin") {
            Glide.with(context).load(R.drawable.bespin).override(70, 70).into(holder?.imagePlanets)
        } else {
            Glide.with(context).load(R.drawable.no_image10).into(holder?.imagePlanets)
        }
    }

    override fun getItemCount(): Int {
        return planetsList.size
    }

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var firstTextView: TextView
        var secondTextView: TextView
        var imagePlanets: ImageView

        init {
            firstTextView = view.findViewById(R.id.TVplanetsFirst) as TextView
            secondTextView = view.findViewById(R.id.TVplanetsSecond) as TextView
            imagePlanets = view.findViewById(R.id.IVplanetsImage) as ImageView
        }
    }


}


