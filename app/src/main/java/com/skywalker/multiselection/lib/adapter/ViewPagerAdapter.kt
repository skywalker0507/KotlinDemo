package com.skywalker.multiselection.lib.adapter

import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/
class ViewPagerAdapter(val pageWidth:Float):PagerAdapter() {

    lateinit var pageLeft:View
    lateinit var pageRight:View

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return 2
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val viewPager=container as ViewPager
        val view=getView(position)
        viewPager.addView(view)
        view.tag=position
        return view
    }

    private fun getView(position:Int):View{
        return when(position){
            0 -> pageLeft
            1 -> pageRight
            else -> throw IllegalArgumentException()
        }
    }
}