package com.example.covid_update

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(val item :ArrayList<CountryModel>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val country :TextView= itemView.findViewById(R.id.tvCountryName)
        val flag : ImageView = itemView.findViewById(R.id.imageFlag)


        }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_custom_item,parent,false)

      return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = item[position]
        holder.country.setText(currentItem.country)
       // holder.flag.adjustViewBounds = currentItem.flag

    }


}

