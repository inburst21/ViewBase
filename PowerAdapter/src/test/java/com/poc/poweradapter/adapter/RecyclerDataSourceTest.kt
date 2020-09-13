package com.poc.poweradapter.adapter

import android.view.View
import android.view.ViewGroup
import com.poc.poweradapter.item.ItemRenderer
import com.poc.poweradapter.item.RecyclerItem
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class RecyclerDataSourceTest {

    private val mRendererOne = TestRenderer(1)
    private val mRendererTwo = TestRenderer(2)
    private val mItemOne = TestItem(1, "r1")
    private val mItemTwo = TestItem(2, "r1")
    private val mItemThree = TestItem(3, "r2")

    private lateinit var mDataSource: RecyclerDataSource

    @Before
    fun setUp() {
        val items = arrayListOf(mItemOne, mItemTwo, mItemThree)
        val renderers = hashMapOf<String, ItemRenderer<in RecyclerItem>>()
        renderers["r1"] = mRendererOne
        renderers["r2"] = mRendererTwo
        mDataSource = RecyclerDataSource(renderers)
        mDataSource.seedData(items)
    }

    @Test
    fun rendererForType() {
        assertEquals(mRendererOne, mDataSource.rendererForType(mRendererOne.layoutRes()))
        assertEquals(mRendererTwo, mDataSource.rendererForType(mRendererTwo.layoutRes()))
    }

    @Test
    fun viewResourceForPosition() {
        assertEquals(mRendererOne.layoutRes(), 1)
        assertEquals(mRendererTwo.layoutRes(), 2)
    }

    @Test
    fun getCount() {
        assertEquals(3, mDataSource.getCount())
    }

    @Test
    fun getItem() {
        assertEquals(mItemOne, mDataSource.getItem(0))
        assertEquals(mItemThree, mDataSource.getItem(2))
    }

    companion object {
        class TestItem(private val id: Long, private val key: String) : RecyclerItem {
            override fun getId(): Long {
                return id
            }

            override fun renderKey(): String {
                return key
            }

        }

        class TestRenderer(private val layoutRes: Int) : ItemRenderer<RecyclerItem> {

            override fun createView(parent: ViewGroup): View {
                TODO("Not yet implemented")
            }

            override fun bind(item: RecyclerItem) {
                TODO("Not yet implemented")
            }

            override fun layoutRes(): Int {
                return layoutRes
            }
        }
    }
}