package com.example.mobilelab.Lab1.Bai2

class SquareCabin : Dwelling() {
    override val buildingMaterial = "Wood"

    override fun floorArea(): Double {
        return 50.0
    }
}
fun main() {
    println("\n=== KET QUA NHA CUA (SQUARE CABIN) ===")
    // Tạo một ngôi nhà cabin gỗ
    val myCabin = SquareCabin()

    // In thông tin về ngôi nhà dựa trên các thuộc tính đã ghi đè (override)
    println("Vat lieu xay dung: ${myCabin.buildingMaterial}")
    println("Dien tich san: ${myCabin.floorArea()} m2")
    with(myCabin) {
        println("Dang kiem tra cabin ... vat lieu la $buildingMaterial")
    }
}