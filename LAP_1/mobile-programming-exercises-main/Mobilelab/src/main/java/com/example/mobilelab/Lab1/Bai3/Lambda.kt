package com.example.mobilelab.Lab1.Bai3

fun main(){
    println("=== LAMBDA VA TOAN TU ELVIS ===")

    // Hàm Lambda: Tự định nghĩa hàm nhân 3 giá trị [2]
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println("Dung lambda de nhan 3 so 5: ${triple(5)}")

    // Toán tử Elvis (?:) xử lý null [5]
    var quantity: Int? = null // Biến này có thể bị null
    // Nếu quantity là null thì lấy số 0
    val shipment = quantity ?: 0
    println("Gia tri shipment (dung Elvis): $shipment")

    // Thao tác chuỗi phức tạp [3]
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val processedWords = words
        .filter { it.startsWith("b", ignoreCase = true) } // Lấy từ bắt đầu bằng 'b'
        .shuffled() // Xáo trộn ngẫu nhiên
        .take(2)    // Chỉ lấy 2 từ
        .sorted()   // Sắp xếp lại
    println("Xu ly chuoi (loc 'b', xao tron, lay 2): $processedWords")
}
