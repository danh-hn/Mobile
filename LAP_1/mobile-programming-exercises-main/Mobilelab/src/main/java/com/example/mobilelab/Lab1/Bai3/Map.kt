package com.example.mobilelab.Lab1.Bai3

fun main(){
    println("=== QUAN LY SO DO (MAP)===")
    // tao danh sach ten va tuoi
    val peopleAges = mutableMapOf<String, Int>("Fred" to 30, "Ann" to 23)
    // them nguoi moi vo map
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println("Danh sach ten va tuoi: ${peopleAges}")
    // su dung map de tao cau gioi thieu
    println("Gioi thieu nhan su")
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()
    // su dung filter de loc nguoi co ten ngan nhat
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println("Danh sach ten ngan nhat: $filteredNames")

}