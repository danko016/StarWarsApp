package com.example.dev.peoplestar.person_component

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.model.Person

/**
 * Created by dev on 29.06.16..
 */
class PersonAdapter(var person: List<Person>) : RecyclerView.Adapter<PersonAdapter.MyViewHolderPerson>() {



    override fun getItemCount(): Int {
        return person.size
    }

    override fun onBindViewHolder(holder: MyViewHolderPerson, position: Int) {

        val person = person.get(position)
        holder.tvPersonName.setText(person.name)
        holder.tvYear.setText(person.birthYear)
        holder.tvGender.setText(person.gender)
        holder.tvHeight.setText(person.height)
        holder.tvHomeworld.setText(person.homeworld)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolderPerson {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.person_list, parent, false)
        return MyViewHolderPerson(itemView)
    }

    class MyViewHolderPerson(view: View) : RecyclerView.ViewHolder(view){

        var tvPersonName: TextView
        var tvYear: TextView
        var tvGender: TextView
        var tvHeight: TextView
        var tvHomeworld: TextView

        init {
            tvPersonName = view.findViewById(R.id.tvPersonName) as TextView
            tvYear = view.findViewById(R.id.tvYear) as TextView
            tvGender = view.findViewById(R.id.tvGender) as TextView
            tvHeight = view.findViewById(R.id.tvHeight) as TextView
            tvHomeworld = view.findViewById(R.id.tvHomeworld) as TextView

        }
    }
}

