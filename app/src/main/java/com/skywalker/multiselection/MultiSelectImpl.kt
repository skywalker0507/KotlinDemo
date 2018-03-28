package com.skywalker.multiselection

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import com.skywalker.multiselection.lib.MultiSelect
import com.skywalker.multiselection.lib.adapter.BaseLeftAdapter
import com.skywalker.multiselection.lib.adapter.BaseRightAdapter
import com.skywalker.multiselection.lib.adapter.ViewPagerAdapter


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/
class MultiSelectImpl<I : Comparable<I>>(context: Context, val parent: ViewGroup) : MultiSelect<I>, FrameLayout(context) {

    init {
        isSaveEnabled = true

    }

    private val STATE_SUPER = "state super"
    private val STATE_SELECTED = "state selected"
    private val STATE_LEFT_POS = "state left pos"
    private val STATE_RIGHT_POS = "state right pos"

    private val location = intArrayOf(0, 0)
    private var pageWidth: Float = 0f

    override val recyclerLeft: RecyclerView by lazy {

    }

    override val recyclerRight: RecyclerView by lazy {

    }

    override val selectedItems: List<I>?
        get() = (recyclerRight.adapter as BaseRightAdapter<I, *>).items

    override var leftAdapter: BaseLeftAdapter<I, out RecyclerView.ViewHolder>?
        get() = recyclerLeft.adapter as BaseLeftAdapter<I, out RecyclerView.ViewHolder>
        set(value) {
            recyclerLeft.adapter = value
        }

    override var rightAdapter: BaseRightAdapter<I, out RecyclerView.ViewHolder>?
        get() = recyclerRight.adapter as BaseRightAdapter<I, out RecyclerView.ViewHolder>
        set(value) {
            recyclerRight.adapter = value
        }

    private val viewPager: MultiSelectViewPager
    private lateinit var pagesAdapter: ViewPagerAdapter

    init {
        val view=LayoutInflater.from(context).inflate()

    }

    override fun select(position: Int) {
    }

    override fun deselect(position: Int) {
    }

    override fun showSelectedPage() {
    }

    override fun showNotSelectedPage() {
    }

    override fun setSidebarWidthDp(iconWidthDp: Float) {
    }

}