package com.skywalker.multiselection.lib.adapter

import android.support.v7.util.SortedList
import android.support.v7.widget.RecyclerView
import com.skywalker.multiselection.lib.callbacks.SortedListCallback


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/
abstract class BaseLeftAdapter<I:Comparable<I>,VH:RecyclerView.ViewHolder>:BaseAdapter<I,VH> {
    lateinit var items:SortedList<I>
    //private constructor():super()
    constructor(kclass:Class<I>):super(){
        items= SortedList(kclass,object :SortedListCallback<I>(){})
    }

    override fun getItemCount(): Int {
        return items.size()
    }

    override fun indexOf(item: I): Int {
        return items.indexOf(item)
    }

    override fun removeItemAt(index: Int): I {
        return items.removeItemAt(index).apply {
            notifyItemRemoved(index)
        }
    }

    override fun add(item: I, hide: Boolean): Int {
        return items.add(item).apply {
            notifyItemInserted(this)
            if (hide){
                hiddenItems.add(item)
            }
        }
    }

    override fun addAll(list: List<I>) {
        items.addAll(list)
    }

    override fun getItemAt(index: Int): I {
        return items.get(index)
    }
}