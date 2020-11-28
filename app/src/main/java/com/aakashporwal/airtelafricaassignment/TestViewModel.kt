package com.aakashporwal.airtelafricaassignment

import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    private val speakerTestModel = TestModel()

    fun checkMessage(message: String): Boolean {
        return speakerTestModel.checkMessage(message)
    }
}