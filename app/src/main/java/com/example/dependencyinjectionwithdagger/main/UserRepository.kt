package com.example.dependencyinjectionwithdagger.main

import android.util.Log
import javax.inject.Inject

interface UserRepository {
    fun saveUser(email: String, password: String)
}

class localDbStore @Inject constructor(): UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "saveUser: In local db")
    }
}

class firebaseStore @Inject constructor(): UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "saveUser: in firebase")
    }

}