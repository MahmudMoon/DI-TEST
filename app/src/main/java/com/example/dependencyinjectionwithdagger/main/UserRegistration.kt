package com.example.dependencyinjectionwithdagger.main

import com.example.dependencyinjectionwithdagger.annotations.FirebaseDb
import javax.inject.Inject
import javax.inject.Named

class UserRegistration @Inject constructor (@Named("email") var sendEmails: NotificationService,
                                            @FirebaseDb var userRepository: UserRepository
) {
    fun registerUser(){
        sendEmails.send("reply@gmail.com", "Email body", "no_re-ply@gmail.com")
        userRepository.saveUser("reply@gmail.com", "123445")
    }
}