package com.example.mobilelab.Lab1.Bai3

fun main(){
    println("=== XU LY NHOM SET ===")

    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("Danh sach  goc: $numbers")

    // phep toan giao( tim diem chung giua 2 nhom)
    val set1 = setOf(1, 2, 3)
    val set2 = setOf(3, 4, 5,)
    println("Giao cua set1 va set2 la: ${set1.intersect(set2)}")
    println("Hieu cua set1 va set2 la: ${set1.subtract(set2)}")
    println("Hop cua set1 va set2 la: ${set1.union(set2)}")
}