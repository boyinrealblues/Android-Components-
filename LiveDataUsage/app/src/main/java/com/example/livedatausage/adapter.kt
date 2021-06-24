package com.example.livedatausage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "adapter"
class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var oldList = MutableList(20,{index-> index*1})

    class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.whole_text)
        fun bind(data : Int){
           textView.setText(data.toString())
        }
    }

    fun setData(newList : MutableList<Int>){
        Log.e(TAG,newList.toString())
        val diff = MyDiffUtil(oldList,newList)
        val diffcalc = DiffUtil.calculateDiff(diff)
        oldList=newList
        Log.e(TAG,oldList.toString())
        diffcalc.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
        Log.e("TAG",oldList[position].toString())
        holder.bind(oldList[position])
    }

    override fun getItemCount() = oldList.size

}