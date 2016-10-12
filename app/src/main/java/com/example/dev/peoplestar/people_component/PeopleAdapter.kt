package com.example.dev.peoplestar.people_component

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.dev.peoplestar.R
import com.example.dev.peoplestar.model.Person
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

/**
 * Created by dev on 29.06.16..
 */
class PeopleAdapter
@Inject
constructor(val context: Context, val peopleList: MutableList<Person>) : RecyclerView.Adapter<PeopleAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val people = peopleList[position]
        holder.tvName.text = people.name
        holder.tvYear.text = people.gender
        holder.tvUrl.text = "#" + people.url.substringBeforeLast("/").substringAfterLast("/")

        if (holder.tvName.text == "Luke Skywalker") {
            Glide.with(context).load(R.drawable.luke).centerCrop().into(holder.firstImage)
        } else if (holder.tvName.text.contains("C-3PO")) {
            Glide.with(context).load(R.drawable.c3).centerCrop().into(holder.firstImage)
        } else if (holder.tvName.text == "R2-D2") {
            Glide.with(context).load(R.drawable.r2d21).into(holder.firstImage)
        } else if (holder.tvName.text == "Darth Vader") {
            Glide.with(context).load(R.drawable.darth_vader2).override(70, 70).into(holder.firstImage)
        } else {
            Glide.with(context).load(R.drawable.no_image10).into(holder.firstImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.people_list, parent, false)
        Log.d("tag", "oncreateviewholder")
        return MyViewHolder(itemView)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        override fun onClick(v: View?) {
            EventBus.getDefault().post(Event(adapterPosition))
        }

        var tvName: TextView
        var tvYear: TextView
        var tvUrl: TextView
        var firstImage: ImageView

        init {

            tvName = view.findViewById(R.id.tvName) as TextView
            tvYear = view.findViewById(R.id.tvYear) as TextView
            tvUrl = view.findViewById(R.id.tvUrl) as TextView
            firstImage = view.findViewById(R.id.IVfirstImage) as ImageView
            itemView.setOnClickListener(this)
        }
    }

    class Event(val position: Int){

    }
}

