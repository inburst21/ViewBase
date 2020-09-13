package io.neverstoplearning.advancedandroid

import android.os.Bundle
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.poc.poweradapter.adapter.RecyclerAdapter
import com.poc.poweradapter.adapter.RecyclerDataSource
import com.poc.poweradapter.item.ItemRenderer
import com.poc.poweradapter.item.RecyclerItem
import io.neverstoplearning.advancedandroid.base.BaseRenderer
import io.neverstoplearning.advancedandroid.common.SelectableTextItem
import io.neverstoplearning.advancedandroid.common.SelectableTextRenderer
import io.neverstoplearning.advancedandroid.databinding.ItemSelectableTextBinding

class BaseActivity : AppCompatActivity() {

    private val mTestItem = SelectableTextItem(true, "test one")
    private val mTestItem2 = SelectableTextItem(true, "test two")
    private val mTestItem3 = SelectableTextItem(true, "test three")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
    }

    private fun initList() {
        val mRecyclerView = findViewById<RecyclerView>(R.id.view_item_list)
        val items = arrayListOf(mTestItem, mTestItem2, mTestItem3)
        val renderers = hashMapOf<String, ItemRenderer<RecyclerItem>>()
        renderers[SelectableTextRenderer.tag] = SelectableTextRenderer()
        val dataSource = RecyclerDataSource(renderers)
        val adapter = RecyclerAdapter(dataSource)
        dataSource.attachToAdapter(adapter)
        dataSource.setData(items)
        mRecyclerView.adapter = adapter
        mRecyclerView.adapter!!.notifyDataSetChanged()
    }
}