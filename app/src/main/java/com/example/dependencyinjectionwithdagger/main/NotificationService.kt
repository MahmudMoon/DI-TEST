package com.example.dependencyinjectionwithdagger.main

import android.util.Log
import com.example.dependencyinjectionwithdagger.app.Analytics
import javax.inject.Inject
import javax.inject.Singleton

interface NotificationService {
    fun send(email: String, body: String, from: String)
}

class SendEmails constructor(private val retry: Int, val analytics: Analytics): NotificationService {
    override fun send(email: String, body: String, from: String) {
        Log.d(TAG, "onEmailSend: retry ${retry}")
        analytics.sendDataToAnalytics("test", "POST")
    }
}

@Singleton
class SendMessage @Inject constructor(val analytics: Analytics): NotificationService {
    override fun send(email: String, body: String, from: String) {
        Log.d(TAG, "onMEssageSend: ")
        analytics.sendDataToAnalytics("test", "POST")
    }
}