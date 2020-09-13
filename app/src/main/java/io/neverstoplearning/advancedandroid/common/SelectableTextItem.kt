package io.neverstoplearning.advancedandroid.common

import com.poc.poweradapter.item.RecyclerItem

data class SelectableTextItem(val isChecked: Boolean, val text: String): RecyclerItem {
    override fun renderKey(): String {
        return SelectableTextRenderer.tag
    }
}