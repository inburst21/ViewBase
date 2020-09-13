package com.poc.poweradapter.adapter

import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.poc.poweradapter.item.ItemRenderer
import com.poc.poweradapter.item.RecyclerItem
import java.lang.ref.WeakReference
import kotlin.collections.Map.Entry

class RecyclerDataSource(private val mRenderers: Map<String, ItemRenderer<in RecyclerItem>>) {

    private val mViewTypeRendererKeyMap: HashMap<Int, String> = hashMapOf()
    private val mData: ArrayList<RecyclerItem> = arrayListOf()

    private var mAdapterReference: WeakReference<RecyclerView.Adapter<in RecyclerViewHolder>> = WeakReference(null)

    init {
        for(entry: Entry<String, ItemRenderer<RecyclerItem>> in mRenderers.entries) {
            mViewTypeRendererKeyMap[entry.value.layoutRes()] = entry.key
        }
    }

    @MainThread
    fun setData(updatedData: List<RecyclerItem>) {
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(RecyclerDiffCallback(mData, updatedData))
        mData.clear()
        mData.addAll(updatedData)
        val adapter = mAdapterReference.get()
        if(adapter != null) {
            diffResult.dispatchUpdatesTo(adapter)
        }
    }

    fun rendererForType(viewType: Int): ItemRenderer<RecyclerItem> {
        return mRenderers[mViewTypeRendererKeyMap[viewType]]!!
    }

    @LayoutRes
    fun viewResourceForPosition(position: Int): Int {
        return mRenderers.getValue(mData[position].renderKey()).layoutRes()
    }

    fun getCount(): Int {
        return mData.size
    }

    fun getItem(position: Int): RecyclerItem {
        return mData[position]
    }

    fun attachToAdapter(adapter: RecyclerView.Adapter<in RecyclerViewHolder>) {
        mAdapterReference = WeakReference(adapter)
    }

    @VisibleForTesting
    fun seedData(data: List<RecyclerItem>) {
        this.mData.clear()
        this.mData.addAll(data)
    }
}