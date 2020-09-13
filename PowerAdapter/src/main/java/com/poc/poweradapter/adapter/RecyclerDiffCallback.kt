package com.poc.poweradapter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.poc.poweradapter.item.RecyclerItem

class RecyclerDiffCallback(private val oldList: List<RecyclerItem>, private val newList: List<RecyclerItem>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].getId() == newList[newItemPosition].getId()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}