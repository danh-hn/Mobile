package com.example.mobilelab.Lab1.Bai4

import kotlinx.coroutines.delay
object DataProviderManager {
    // ham tam ngung (suspend): gia lap viecj ton thoi gian tinh toan
    suspend fun getTemperature(): Double {
        delay(1000)
        return 29.5
    }
    fun simulateError() {
        throw RuntimeException("Mat ket noi den cam bien")
    }
}