package com.aakashporwal.airtelafricaassignment

class TestModel {
    companion object {
        private const val MESSAGE = "Airtel Africa Assignment"
    }

    fun checkMessage(message: String): Boolean {
        return MESSAGE.equals(message, false)
    }
}