package com.skywalker.multiselection.lib.callbacks

import android.support.v7.util.SortedList


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/
open class SortedListCallback<I:Comparable<I>>:SortedList.Callback<I>() {
    override fun areItemsTheSame(item1: I, item2: I): Boolean {
        return item1 == item2
    }

    override fun onMoved(fromPosition: Int, toPosition: Int) {
    }

    override fun onChanged(position: Int, count: Int) {
    }

    override fun onInserted(position: Int, count: Int) {
    }

    override fun onRemoved(position: Int, count: Int) {
    }

    override fun compare(o1: I, o2: I): Int {
        return o1.compareTo(o2)
    }

    override fun areContentsTheSame(oldItem: I, newItem: I): Boolean {
        return oldItem.equals(newItem)
    }
}