package com.example.diffutildemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutildemo.Util.MyDiff

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.MyViewHolder>(){

    private var oldList = mutableListOf(Details(0,"","",""))

    class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val nameText : TextView
        val email : TextView
        val sb : StringBuffer
        init{
            nameText = view.findViewById<TextView>(R.id.whole_text)
            email = view.findViewById<TextView>(R.id.meta_text)
            sb = StringBuffer()
        }
        fun bind(data : Details){
            sb.append(data.firstName+" ").append((data.lastName))
            nameText.setText(sb)
            email.setText(data.email)
        }
    }
    
    fun setData(newList : MutableList<Details>){
        val diff = MyDiff(oldList = oldList, newList)
        val calcDiff= DiffUtil.calculateDiff(diff)
        oldList = newList
        calcDiff.dispatchUpdatesTo(this)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_view,parent,false)
            return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(oldList[position])
    }

    override fun getItemCount(): Int  =oldList.size

}