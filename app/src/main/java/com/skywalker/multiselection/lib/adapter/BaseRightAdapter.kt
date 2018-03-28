package com.skywalker.multiselection.lib.adapter

import android.support.v7.widget.RecyclerView


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/
abstract class BaseRightAdapter<I:Comparable<I>,VH:RecyclerView.ViewHolder>:BaseAdapter<I,VH>() {
    var items:MutableList<I> = mutableListOf()
    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemAt(index: Int): I {
        return items[index]
    }

    override fun indexOf(item: I): Int {
        return items.indexOf(item)
    }

    override fun removeItemAt(index: Int): I {
        return items.removeAt(index).apply {
            notifyItemRemoved(index)
        }
    }

    override fun add(item: I, hide: Boolean): Int {
        if (hide){
            hiddenItems.add(item)
        }
        items.add(item)
        return (items.count()-1).apply {
            notifyItemInserted(this)
        }
    }

    override fun addAll(list: List<I>) {
        items.addAll(list)
    }
}