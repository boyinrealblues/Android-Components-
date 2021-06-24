package com.example.diffutildemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutildemo.Util.MyDiff

//Adapter Class
class DetailAdapter : RecyclerView.Adapter<DetailAdapter.MyViewHolder>(){

    //Temporary list to be replaced by NewList from the setData::
    private var oldList = mutableListOf(Details(0,"","",""))


    //Inner Class ViewHolder
    class MyViewHolder(private val view : View) : RecyclerView.ViewHolder(view){

        val nameText : TextView
        val email : TextView
        val sb : StringBuffer
        init{
            //Views Init
            nameText = view.findViewById<TextView>(R.id.whole_text)
            email = view.findViewById<TextView>(R.id.meta_text)
            sb = StringBuffer()
        }

        //To update views in the viewHolder
        fun bind(data : Details){
            sb.append(data.firstName+" ").append((data.lastName))
            nameText.setText(sb)
            email.setText(data.email)
        }
    }

    //Function to update the old list with new list using DiffUtil
    fun setData(newList : MutableList<Details>){
        //Class defined
        val diff = MyDiff(oldList, newList)
        //????
        val calcDiff= DiffUtil.calculateDiff(diff)
        oldList = newList
        //Dispatch update - Used always inside an adapter
        calcDiff.dispatchUpdatesTo(this)
    }

    //Adapter Overrides
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_view,parent,false)
            return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(oldList[position])
    }

    override fun getItemCount(): Int  =oldList.size

}