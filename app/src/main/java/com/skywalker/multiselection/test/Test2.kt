package com.skywalker.multiselection.test

import android.util.Log
import kotlin.coroutines.experimental.*


/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/3/28               *
 *******************************/

val TAG="test2"

fun main(args: Array<String>) {
    Log.e(TAG,"before coroutine")
    //启动我们的协程
    asyncCalcMd5("test.zip") {
        Log.e(TAG,"in coroutine. Before suspend.")
        //暂停我们的线程，并开始执行一段耗时操作
        val result: String = suspendCoroutine {
            continuation ->
            Log.e(TAG,"in suspend block.")
            continuation.resume(calcMd5(continuation.context[FilePath]!!.path))
            Log.e(TAG,"after resume.")
        }

        Log.e(TAG,"in coroutine. After suspend. result = $result")
    }
    Log.e(TAG,"after coroutine")
}



class FilePath(val path: String): AbstractCoroutineContextElement(FilePath){
    companion object Key : CoroutineContext.Key<FilePath>
}

fun asyncCalcMd5(path: String, block: suspend () -> Unit) {
    val continuation = object : Continuation<Unit> {
        override val context: CoroutineContext
            get() = FilePath(path)

        override fun resume(value: Unit) {
            Log.e(TAG,"resume: $value")
        }

        override fun resumeWithException(exception: Throwable) {
            Log.e(TAG,exception.toString())
        }
    }
    block.startCoroutine(continuation)
}

fun calcMd5(path: String): String{
    Log.e(TAG,"calc md5 for $path.")
    //暂时用这个模拟耗时
    Thread.sleep(1000)
    //假设这就是我们计算得到的 MD5 值

    return System.currentTimeMillis().toString()
}
