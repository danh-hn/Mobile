package com.example.mobilelab.Lab1.Bai1

// * : multiplication
// / : division
// + : addition
// - : subtraction
// = : assignment

// > : greater than
// < : less than
// >= : greater than or equal to
// <= : less than or equal to
// == : equal to
// != : not equal to

// && : and
// || : or
// ! : not

fun main() {
    val diceRange = 1..1000000
    val randomNumber = diceRange.random()

    fun roll() {
        val anotherRandomNumber = (1..1000000).random()
        println("Random number: $anotherRandomNumber")
        println("Random number: $randomNumber")
    }
    roll()
    roll()

}
