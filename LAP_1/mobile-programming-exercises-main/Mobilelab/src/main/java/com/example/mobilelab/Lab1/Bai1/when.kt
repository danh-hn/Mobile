package com.example.mobilelab.Lab1.Bai1



fun main(){
    val rollResult = (1..6).random()
    val luckyNumber = 0
    when (rollResult) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }
    val diceRoll = (1..6).random()
    val drawableResource = when (diceRoll) {
        1 -> 1
        2 -> 2
        3 -> 3
        4 -> 4
        5 -> 5
        else -> 6
    }
    println("You rolled a dice_$drawableResource")
}
