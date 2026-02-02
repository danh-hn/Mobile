package com.example.baitap.Bai1

// Val biến không thay đôỉ.
val age = "19"
val name = "Danh"
// Var biến thay đổi.
var roll = 6
var rolledValue: Int = 4
fun printHello () {
    println ("Hello Kotlin")
}

fun main() {
    println("Hello!")
    println("My name is ${name}, ${age} years old.")

    // Gọi hàm.
    printHello()

    println("Tung xúc xắc: ${roll()}")

    printBorder("K", 10)
}

fun printBorder(border: String, timesToRepeat: Int) {
    repeat(timesToRepeat) {
        print(border)
    }
    println()
}

fun roll(): Int {
    val randomNumber = (1..6).random()
    return randomNumber
}

