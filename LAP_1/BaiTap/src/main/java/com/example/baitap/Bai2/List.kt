package com.example.mobilelab.Lab1.Bai2

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("Danh sach so co dinh: ${numbers}")
    println("Lay so luong phan tu: ${numbers.size}")

    val entrees = mutableListOf<String>()
    println("Thuc don ban dau: $entrees")

    entrees.add("spaghetti")
    entrees.add("lasagna")
    entrees.add("french fries")
    entrees.add("hamburger")
    println("Thuc don sau khi them: $entrees")

    entrees.remove("french fries")
    println("Thuc don sau khi xoa: $entrees")
    println("Duyet danh sach mon an: ")
    for (element in entrees) {
        println(element)
    }
    println()

}