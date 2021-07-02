package com.example.recyclerviewinsights.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewinsights.Data.Covid
import com.example.recyclerviewinsights.R

class CovidAdapter : RecyclerView.Adapter<CovidAdapter.CovidViewHolder>() {

        var oldList:List<Covid> = emptyList<Covid>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CovidViewHolder {
        return CovidViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
         holder.bind(oldList[position])
    }

    override fun getItemCount()=oldList.size

    class CovidViewHolder(private val view : View) : RecyclerView.ViewHolder(view){
        private val text : TextView
        init{
            text = view.findViewById<TextView>(R.id.text)
        }

        fun bind(item : Covid){
            val sb = StringBuffer()
            sb.append(item.country)
            text.setText(sb)
        }
        companion object{
            fun create(parent:ViewGroup):CovidViewHolder{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.covid_view_holder,parent,false)
                return CovidViewHolder(view)
                }
        }
    }

    fun submitList(newList:List<Covid>){
        oldList = newList
    }

}
