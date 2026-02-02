package com.example.mobilelab.Lab1.Bai1

class Dice {
    var sides = 6

    fun roll(){
        val randomNumber = (1..6).random()
        println(randomNumber)
    }
}

class Dice2(val numSides: Int) {
    fun roll(): Int {
        val randomNumber = (1..numSides).random()
        return randomNumber
    }
}


fun main(){
    // Tao 1 doi tuong xuc xac lop Dice
    val myFirstDice = Dice()
    val mySecondDice = Dice2(8)

    println("${mySecondDice.numSides}")
    mySecondDice.roll()

    // truy cap thuoc tinh
    println("xuc xac cua toi do lan thu ${myFirstDice.sides}")
    myFirstDice.roll()
    println("xuc xac cua toi do lan thu ${myFirstDice.sides}")
    myFirstDice.roll()
}
