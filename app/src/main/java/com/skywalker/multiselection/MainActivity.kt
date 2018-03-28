package com.skywalker.multiselection

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*async(UI){
            val data:Deferred<String> = bg {
                getData()
            }
            showData(data.await())
        }*/


        launch(CommonPool) {
            delay(3000)
            async(UI) {
                toast("1").show()
            }.await()

            delay(2000)
            async(UI) {
                toast("2").show()
            }.await()

            var t=bg {
               return@bg 10
            }.await()
        }

        toast("3").show()

        launch(UI) {
            val t = async(CommonPool) {

                return@async 10
            }.await()

            tv.text = t.toString()
        }
    }


    private fun getData(): String {

        val http = OkHttpClient()
        val request = Request.Builder().url("http://www.baidu.com").build()
        val response = http.newCall(request).execute()
        return response.body().toString()
    }

    private fun showData(msg: String) {
        tv.text = msg
    }

}
