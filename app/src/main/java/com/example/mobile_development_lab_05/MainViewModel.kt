package com.example.mobile_development_lab_05

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var time : Int = 0
    var rate : Int = 0
    var discount : Int = 0

    val cost: Int
        get() = time * rate * discount

}