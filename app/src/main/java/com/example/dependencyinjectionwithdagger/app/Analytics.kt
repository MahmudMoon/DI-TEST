package com.example.dependencyinjectionwithdagger.app

import android.util.Log
import com.example.dependencyinjectionwithdagger.main.TAG
import javax.inject.Inject

interface Analytics {
    fun sendDataToAnalytics(data: String, method: String)
}

class FirebaseAnalytics @Inject constructor(): Analytics{
    override fun sendDataToAnalytics(data: String, method: String) {
        Log.d("MAIN", "sendDataToAnalytics: using Firebase")
    }
}

class MixAnalytics @Inject constructor(): Analytics{
    override fun sendDataToAnalytics(data: String, method: String) {
        Log.d("MAIN", "sendDataToAnalytics: using Mix Analytics")
    }
}