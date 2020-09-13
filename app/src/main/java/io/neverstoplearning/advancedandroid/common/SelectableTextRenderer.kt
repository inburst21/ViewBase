package io.neverstoplearning.advancedandroid.common

import androidx.annotation.LayoutRes
import io.neverstoplearning.advancedandroid.R
import io.neverstoplearning.advancedandroid.base.CommonRenderer
import io.neverstoplearning.advancedandroid.databinding.ItemSelectableTextBinding

class SelectableTextRenderer: CommonRenderer<SelectableTextItem, ItemSelectableTextBinding>(layoutRes) {

    companion object {
        const val tag = "SelectableItem"
        @LayoutRes
        const val layoutRes = R.layout.item_selectable_text
    }

    override fun bind(item: SelectableTextItem) {
        binding = ItemSelectableTextBinding.bind(view)
        binding.model = item
        binding.executePendingBindings()
    }
}