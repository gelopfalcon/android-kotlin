package com.example.lab6

import android.util.Log
import androidx.lifecycle.ViewModel

class SumViewModel : ViewModel() {
    var total: Int = 0

    fun changeMainText(){
        total += 1
        Log.i("",total.toString())
    }
}