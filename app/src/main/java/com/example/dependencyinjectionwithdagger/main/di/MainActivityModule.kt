package com.example.dependencyinjectionwithdagger.main.di

import com.example.dependencyinjectionwithdagger.*
import com.example.dependencyinjectionwithdagger.annotations.FirebaseDb
import com.example.dependencyinjectionwithdagger.annotations.LocalDb
import com.example.dependencyinjectionwithdagger.app.Analytics
import com.example.dependencyinjectionwithdagger.app.MyApp
import com.example.dependencyinjectionwithdagger.main.*
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class MainActivityModule(private val retry: Int,val analytics: Analytics) {

    @Provides
    fun getMyAppObject(): MyApp{
        return MyApp()
    }

    @LocalDb
    @Provides
    fun getLocalDb(): UserRepository {
        return localDbStore()
    }

    @FirebaseDb
    @Provides
    fun getFirebaseDb(): UserRepository {
        return firebaseStore()
    }

    @Named("message")
    @Provides
    fun getNotificationViaMessage(): NotificationService {
        return SendMessage(analytics)
    }

    @Named("email")
    @Provides
    fun getNotificationViaEmail(): NotificationService {
        return SendEmails(retry,analytics)
    }
}