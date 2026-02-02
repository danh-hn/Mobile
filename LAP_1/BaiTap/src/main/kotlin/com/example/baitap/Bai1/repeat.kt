package com.example.baitap.Bai1
fun main(){
    fun printBorder(){
        repeat(4) {
            print("*")
        }
    }
    printBorder()

    fun printCakeBottom(age: Int, layers: Int){
        repeat(layers) {
            repeat(age + 2) {
                print("@")
            }
            println()
        }
    }
    printCakeBottom(4, 10)
}