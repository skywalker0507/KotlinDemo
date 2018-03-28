package com.skywalker.multiselection.test

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/
fun test1(){
    launch(UI){

    }

    async(UI){
        delay(1000)
    }

    runBlocking(UI){

    }


}