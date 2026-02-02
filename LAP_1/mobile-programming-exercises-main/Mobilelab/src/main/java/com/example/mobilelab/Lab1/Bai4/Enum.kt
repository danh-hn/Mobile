package com.example.mobilelab.Lab1.Bai4

fun main() {
    println("=== KIEM TRA HUONG GIO ===")
    val windDirection = Direction.SOUTH

    when (windDirection) {
        Direction.NORTH -> println("Gio thoi ve huong bac")
        Direction.SOUTH -> println("Gio thoi ve huong nam")
        Direction.EAST -> println("Gio thoi ve huong dong")
        Direction.WEST -> println("Gio thoi ve huong tay")
    }
}