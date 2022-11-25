package com.example.dependencyinjectionwithdagger.main.di

import com.example.dependencyinjectionwithdagger.annotations.ActivityScope
import com.example.dependencyinjectionwithdagger.app.di.AppComponent
import com.example.dependencyinjectionwithdagger.app.di.AppModule
import com.example.dependencyinjectionwithdagger.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}