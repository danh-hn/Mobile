package com.example.xucxac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.xucxac.ui.theme.XUCXACTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XUCXACTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    // Sử dụng Column để xếp hình ảnh và nút bấm theo chiều dọc, căn giữa màn hình
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center), // Căn giữa nội dung
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DiceWithButtonAndImage()
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // --- LOGIC CỦA ỨNG DỤNG ---
    // 1. Tạo một biến trạng thái (state) để lưu giá trị xúc xắc hiện tại.
    // `remember` giúp ghi nhớ giá trị qua các lần vẽ lại giao diện.
    // `mutableStateOf(1)` khởi tạo giá trị ban đầu là 1.
    var result by remember { mutableStateOf(1) }

    // 2. Xác định hình ảnh cần hiển thị dựa trên giá trị `result`
    val imageResource = when (result) {
        1 -> R.drawable.dice_1 // Đảm bảo bạn đã có các ảnh này trong res/drawable
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // --- GIAO DIỆN ---
    // Hiển thị hình ảnh xúc xắc
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = result.toString(), // Mô tả cho trình đọc màn hình
        modifier = modifier
    )

    Spacer(modifier = Modifier.height(16.dp)) // Tạo khoảng cách giữa ảnh và nút

    // Nút bấm "Roll"
    Button(
        onClick = {
            // Khi bấm nút, cập nhật biến trạng thái `result` bằng một số ngẫu nhiên mới
            result = (1..6).random()
        }
    ) {
        Text(text = "Roll")
    }
}