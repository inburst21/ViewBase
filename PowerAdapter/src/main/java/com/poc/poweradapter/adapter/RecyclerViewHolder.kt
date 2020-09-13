package com.poc.poweradapter.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poc.poweradapter.item.ItemRenderer
import com.poc.poweradapter.item.RecyclerItem

class RecyclerViewHolder(parent: ViewGroup, private val renderer: ItemRenderer<in RecyclerItem>) : RecyclerView.ViewHolder(renderer.createView(parent)) {

    fun bind(item: RecyclerItem) {
        renderer.bind(item)
    }
}