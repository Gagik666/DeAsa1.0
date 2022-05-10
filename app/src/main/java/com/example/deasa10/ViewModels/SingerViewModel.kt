package com.example.deasa10.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SingerViewModel: ViewModel() {
    var point = 0
    val liveDataPoint = MutableLiveData<Int>()

    init {
        liveDataPoint
    }

    fun getPoint(p: Int) {
        point += p
        liveDataPoint.value = point
    }
}