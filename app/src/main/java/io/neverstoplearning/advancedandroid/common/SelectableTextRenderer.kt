package io.neverstoplearning.advancedandroid.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.poc.poweradapter.item.ItemRenderer
import com.poc.poweradapter.item.RecyclerItem
import io.neverstoplearning.advancedandroid.R
import io.neverstoplearning.advancedandroid.databinding.ItemSelectableTextBinding

class SelectableTextRenderer: ItemRenderer<RecyclerItem> {

    companion object {
        const val tag = "SelectableItem"
        @LayoutRes
        const val layoutRes = R.layout.item_selectable_text
    }

    private lateinit var viewBinding: ItemSelectableTextBinding

    override fun layoutRes(): Int {
        return layoutRes
    }

    override fun createView(parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(layoutRes(), parent, false)
        viewBinding = ItemSelectableTextBinding.bind(view)
        return viewBinding.root
    }
    override fun bind(item: RecyclerItem) {
        if(item is SelectableTextItem) {
            viewBinding.model = item
            viewBinding.executePendingBindings()
        }
    }
}