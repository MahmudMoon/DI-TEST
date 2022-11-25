package com.example.dependencyinjectionwithdagger.app.di

import android.content.Context
import com.example.dependencyinjectionwithdagger.app.Analytics
import com.example.dependencyinjectionwithdagger.app.MyApp
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
   fun getAnalyticService(): Analytics
}