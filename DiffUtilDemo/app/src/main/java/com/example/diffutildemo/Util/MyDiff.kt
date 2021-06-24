package com.example.diffutildemo.Util

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutildemo.Details

class MyDiff(private var oldList : MutableList<Details>,private var newList : MutableList<Details> ) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize()=newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean{
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        when(true){
            oldList[oldItemPosition].firstName != newList[newItemPosition].firstName ->  return false
            oldList[oldItemPosition].lastName != newList[newItemPosition].lastName -> return false
            oldList[oldItemPosition].email != newList[newItemPosition].email -> return false
            oldList[oldItemPosition].id != newList[newItemPosition].id -> return false
            else -> return true
        }

    }
}