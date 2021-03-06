package io.neverstoplearning.advancedandroid.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.poc.poweradapter.item.ItemRenderer
import com.poc.poweradapter.item.RecyclerItem

abstract class CommonRenderer<T : RecyclerItem, V : ViewBinding>(private val layoutRes: Int) : ItemRenderer<T> {
    lateinit var view: View
    lateinit var binding: V

    override fun layoutRes(): Int {
        return layoutRes
    }

    override fun createView(parent: ViewGroup): View {
        view = LayoutInflater.from(parent.context).inflate(layoutRes(), parent, false)
        return view
    }

    fun getBaseRenderer(): ItemRenderer<RecyclerItem> {
        return this as ItemRenderer<RecyclerItem>
    }
}