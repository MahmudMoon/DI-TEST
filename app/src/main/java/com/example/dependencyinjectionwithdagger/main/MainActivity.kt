package com.example.dependencyinjectionwithdagger.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencyinjectionwithdagger.R
import com.example.dependencyinjectionwithdagger.app.Analytics
import com.example.dependencyinjectionwithdagger.app.MyApp
import com.example.dependencyinjectionwithdagger.app.TextModel
import com.example.dependencyinjectionwithdagger.app.di.AppComponent
import com.example.dependencyinjectionwithdagger.app.di.DaggerAppComponent
import com.example.dependencyinjectionwithdagger.main.di.DaggerMainActivityComponent
import com.example.dependencyinjectionwithdagger.main.di.MainActivityComponent
import com.example.dependencyinjectionwithdagger.main.di.MainActivityModule
import javax.inject.Inject

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var registrationService: UserRegistration

    lateinit var analytics: Analytics
    
    lateinit var textModel: TextModel

    lateinit var emails: SendEmails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        analytics = (application as MyApp).analyticService
        Log.e(TAG, "onCreate: ${analytics.sendDataToAnalytics("", "")}")

        val mainActivityComponent =  DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(4, analytics ))
            .build()

        mainActivityComponent.inject(this)

        registrationService.registerUser()
        
        

    }
}