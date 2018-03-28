package com.skywalker.multiselection.lib.adapter

import android.support.v7.widget.RecyclerView
import android.view.View


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/
abstract class BaseAdapter<I,VH:RecyclerView.ViewHolder>: RecyclerView.Adapter<VH>() {
    val hiddenItems= mutableSetOf<I>()

    abstract fun add(item:I,hide:Boolean=false):Int
    abstract fun removeItemAt(index:Int):I
    abstract fun indexOf(item: I):Int
    abstract fun getItemAt(index: Int):I
    abstract fun addAll(list:List<I>)

    fun showItem(item: I){
        if (hiddenItems.remove(item)){
            notifyItemChanged(indexOf(item))
        }

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.visibility=when{
            hiddenItems.contains(getItemAt(position)) -> View.INVISIBLE
            else -> View.VISIBLE
        }
    }
}