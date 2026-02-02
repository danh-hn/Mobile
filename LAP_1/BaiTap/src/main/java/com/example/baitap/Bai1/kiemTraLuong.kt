package com.example.baitap.Bai1

fun main () {
    printBorder()
    printCakeBottom(age = 5, layers = 3)

    val num = roll1()
    if (num > 4) {
        println("Gia tri lon hon 4")
    } else if (num == 4) {
        println("Gia tri bang 4")
    } else {
        println("Gia tri nho hon 4")
    }

    val luckyNumber = 4

    // Tạo số ngẫu nhiên từ 1 đến 6
    val rollResult = (1..6).random()

    println("Bạn đã đổ được số: $rollResult") // In ra để biết mình vừa đổ số mấy

    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }
}

fun printBorder() {
    repeat(5) {
        print("=")
    }
}

fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}

fun roll1(): Int {
    val randomNumber = (1..6).random()
    return randomNumber
}