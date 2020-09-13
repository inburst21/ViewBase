package io.neverstoplearning.advancedandroid.common

import com.poc.poweradapter.adapter.RecyclerDataSource
import com.poc.poweradapter.item.ItemRenderer
import com.poc.poweradapter.item.RecyclerItem
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class SelectableTextRendererTest {

    private val mRendererOne = SelectableTextRenderer()
    private val mItemOne = SelectableTextItem(false, "Test one")
    private val mItemTwo = SelectableTextItem(false, "Test two")

    private lateinit var mDataSource: RecyclerDataSource

    @Before
    fun setUp() {
        val items = arrayListOf(mItemOne, mItemTwo)
        val renderers = hashMapOf<String, ItemRenderer<in RecyclerItem>>()
        renderers[SelectableTextRenderer.tag] = mRendererOne
        mDataSource = RecyclerDataSource(renderers)
        mDataSource.seedData(items)
    }

    @Test
    fun bind() {
        assertEquals(mRendererOne, mDataSource.rendererForType(mRendererOne.layoutRes()))
    }
}