package com.skywalker.multiselection.lib

import android.support.v7.widget.RecyclerView
import com.skywalker.multiselection.lib.adapter.BaseLeftAdapter
import com.skywalker.multiselection.lib.adapter.BaseRightAdapter


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/
interface MultiSelect<I:Comparable<I>> {
    val recyclerLeft: RecyclerView
    val recyclerRight: RecyclerView

    val selectedItems:List<I>?

    var leftAdapter:BaseLeftAdapter<I,out RecyclerView.ViewHolder>?
    var rightAdapter:BaseRightAdapter<I,out RecyclerView.ViewHolder>?

    fun select(position:Int)
    fun deselect(position: Int)

    fun showSelectedPage()
    fun showNotSelectedPage()

    fun setSidebarWidthDp(iconWidthDp:Float)
}