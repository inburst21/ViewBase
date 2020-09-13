package com.poc.poweradapter.item

import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull

interface ItemRenderer<T : RecyclerItem> {

    fun createView(@NonNull parent: ViewGroup): View
    fun bind(@NonNull item: T)
    fun layoutRes(): Int = 0
}