package com.example.dependencyinjectionwithdagger.app

import android.app.Application
import com.example.dependencyinjectionwithdagger.app.di.AppComponent
import com.example.dependencyinjectionwithdagger.app.di.DaggerAppComponent
import com.example.dependencyinjectionwithdagger.main.NotificationService
import javax.inject.Inject

class MyApp :  Application(){
    lateinit var appComponent: AppComponent
    lateinit var analyticService: Analytics
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
        analyticService = appComponent.getAnalyticService()
    }
}