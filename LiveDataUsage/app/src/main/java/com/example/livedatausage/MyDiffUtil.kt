package com.example.livedatausage

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(private val old:MutableList<Int>,private val new:MutableList<Int>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition]==new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition]==new[newItemPosition]
    }
}