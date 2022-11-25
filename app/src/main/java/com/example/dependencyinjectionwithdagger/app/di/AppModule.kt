package com.example.dependencyinjectionwithdagger.app.di

import com.example.dependencyinjectionwithdagger.app.Analytics
import com.example.dependencyinjectionwithdagger.app.FirebaseAnalytics
import com.example.dependencyinjectionwithdagger.app.TextModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule() {
    @Singleton
    @Provides
    fun getAnalyticsMethod(): Analytics{
        return FirebaseAnalytics()
    }
}