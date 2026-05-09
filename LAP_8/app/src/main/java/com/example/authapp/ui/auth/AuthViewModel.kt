package com.example.authapp.ui.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

// Vị trí: ui/auth/AuthViewModel.kt
class AuthViewModel : ViewModel() {
    private val auth = Firebase.auth

    // State để UI quan sát và cập nhật
    var isLoading = mutableStateOf(false)
    var authError = mutableStateOf<String?>(null)

    var errorMessage = mutableStateOf<String?>(null)

    fun login(email: String, pass: String, onSuccess: () -> Unit) {
        isLoading.value = true
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            isLoading.value = false
            if (task.isSuccessful) onSuccess()
            else errorMessage.value = "Lỗi đăng nhập: ${task.exception?.message}"
        }
    }

    fun register(email: String, pass: String, onSuccess: () -> Unit) {
        isLoading.value = true
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            isLoading.value = false
            if (task.isSuccessful) onSuccess()
            else errorMessage.value = "Lỗi đăng ký: ${task.exception?.message}"
        }
    }
}