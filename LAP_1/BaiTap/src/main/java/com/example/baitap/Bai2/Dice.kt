package com.example.mobilelab.Lab1.Bai2

class Dice(val numSides: Int) {
    fun roll() : Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
    }
}

fun main() {
    // --- PHẦN 1: Lớp và Đối tượng (Class & Object) ---
    println("=== KET QUA XUC XAC ===")
    // Tạo một viên xúc xắc 6 mặt
    val myDice = Dice(6)
    // Gieo xúc xắc và in kết quả
    println("Gieo xuc xac 6 mat, ket qua la: ${myDice.roll()}")
    println("Gieo lan nua: ${myDice.roll()}")
    }