package com.example.dev.peoplestar.ships_component

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.Ship
import javax.inject.Inject

/**
 * Created by dev on 06.10.16..
 */

class ShipsAdapter
@Inject
constructor(val context: Context, val shipsList: MutableList<Ship>) : RecyclerView.Adapter<ShipsAdapter.ShipsViewHolder>() {


    override fun onBindViewHolder(holder: ShipsViewHolder?, position: Int) {
        val ships = shipsList[position]
        holder?.firstText?.text = ships.name
        holder?.secondText?.text = ships.cargoCapacity + " kg"
        holder?.thirdText?.text = ships.crew

        when (holder?.firstText?.text) {
            "Sentinel-class landing craft" -> Glide.with(context).load(R.drawable.sentinel).centerCrop().into(holder?.imageShip)
            "Death Star" -> Glide.with(context).load(R.drawable.deathstar).centerCrop().into(holder?.imageShip)
            "Y-wing" -> Glide.with(context).load(R.drawable.ywing).into(holder?.imageShip)
            "Executor" ->   Glide.with(context).load(R.drawable.executor).override(70, 70).into(holder?.imageShip)
            else ->  Glide.with(context).load(R.drawable.no_image10).into(holder?.imageShip)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ShipsViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.ships_list, parent, false)
        return ShipsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return shipsList.size
    }

    class ShipsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var firstText: TextView
        var secondText: TextView
        var thirdText: TextView
        var imageShip: ImageView

        init {

            firstText = view.findViewById(R.id.TVNameShips) as TextView
            secondText = view.findViewById(R.id.TVSecondOption) as TextView
            thirdText = view.findViewById(R.id.TVThirdOption) as TextView
            imageShip = view.findViewById(R.id.IVFirstImageShips) as ImageView
        }

    }

}