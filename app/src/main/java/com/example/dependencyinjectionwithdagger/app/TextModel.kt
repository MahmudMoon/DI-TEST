package com.example.dependencyinjectionwithdagger.app

import javax.inject.Inject


class TextModel @Inject constructor() {
    val name: String = "test data"
}