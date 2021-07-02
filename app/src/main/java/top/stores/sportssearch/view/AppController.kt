package top.stores.sportssearch.view

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class AppController : Application() {

    init {
        // App Instance test 3r3w
        instance = this
    }

    companion object {
        private var instance: AppController? = null

        fun applicationContext() : AppController {
            return instance as AppController
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

}