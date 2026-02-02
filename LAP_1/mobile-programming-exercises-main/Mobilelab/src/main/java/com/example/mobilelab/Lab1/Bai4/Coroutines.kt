package com.example.mobilelab.Lab1.Bai4

import kotlinx.coroutines.runBlocking

fun main(){
    println("=== TAI DU LIEU THOI TIET ===")

    // Su dung runBlocking de cho cac ham coroutines chay xong
    runBlocking {
        println("Dang tai du lieu thoi tiet ...")
        // goi ham tam ngung (suspend) de lay nhiet do
        val temp = DataProviderManager.getTemperature()
        println("Nhiet do hien tai la: $temp")
    }
    // --- XỬ LÝ LỖI (TRY/CATCH) ---
    println("\n=== XU LY LOI (EXCEPTION) ===")
    try {
        // Cố tình gọi hàm gây lỗi để test tính năng bắt lỗi
        DataProviderManager.simulateError()
    } catch (e: Exception) {
        println("Da bat duoc loi: ${e.message}")
        println("Chuong trinh van tiep tuc chay an toan.")
    }
}