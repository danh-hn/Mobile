package com.example.crud_lap7

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crud_lap7.ui.theme.CRUD_LAP7Theme
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

// FIX 1: Xóa các khai báo property sai ở ngoài class
// private val MainActivity.updatedCourse: Any  <-- SAI, đã xóa
// private val MainActivity.database: Any       <-- SAI, đã xóa
// private val MainActivity.greenColor: Any     <-- SAI, đã xóa

class MainActivity : ComponentActivity() {

    // FIX 2: Khai báo đúng vị trí bên trong class
    private val greenColor = Color(0xFF4CAF50)

    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CRUD_LAP7Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            // FIX 3: Material3 TopAppBar dùng `colors` thay vì `backgroundColor`
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "GFG",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = greenColor
                                )
                            )
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            FirebaseUI(LocalContext.current)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        CRUD_LAP7Theme {
            Greeting("Android")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun FirebaseUI(context: Context) {
        val courseID = remember { mutableStateOf("") }
        val courseName = remember { mutableStateOf("") }
        val courseDuration = remember { mutableStateOf("") }
        val courseDescription = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = courseName.value,
                onValueChange = { courseName.value = it },
                placeholder = { Text(text = "Enter your course name") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = courseDuration.value,
                onValueChange = { courseDuration.value = it },
                placeholder = { Text(text = "Enter your course duration") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = courseDescription.value,
                onValueChange = { courseDescription.value = it },
                placeholder = { Text(text = "Enter your course description") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = androidx.compose.ui.text.TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp
                ),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    if (TextUtils.isEmpty(courseName.value.toString())) {
                        Toast.makeText(context, "Please enter course name", Toast.LENGTH_SHORT).show()
                    } else if (TextUtils.isEmpty(courseDuration.value.toString())) {
                        Toast.makeText(context, "Please enter course Duration", Toast.LENGTH_SHORT).show()
                    } else if (TextUtils.isEmpty(courseDescription.value.toString())) {
                        // FIX 4: Sửa lỗi cú pháp string bị vỡ
                        Toast.makeText(context, "Please enter course description", Toast.LENGTH_SHORT).show()
                    } else {
                        // FIX 5: Gọi trực tiếp hàm addDataToFirebase của class, không qua `database.`
                        addDataToFirebase(
                            courseID.value,
                            courseName.value,
                            courseDuration.value,
                            courseDescription.value,
                            context
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Add Data", modifier = Modifier.padding(8.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    context.startActivity(Intent(context, CourseDetailsActivity::class.java))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "View Courses", modifier = Modifier.padding(8.dp))
            }
        }
    }

    fun addDataToFirebase(
        courseID: String,
        courseName: String,
        courseDuration: String,
        courseDescription: String,
        context: Context
    ) {
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        val dbCourses: CollectionReference = db.collection("Courses")

        // FIX 6: Xóa dòng gọi .set(updatedCourse) không hợp lệ
        // db.collection("Courses").document(courseID.toString()).set(updatedCourse) <-- SAI, đã xóa

        val courses = Course(courseID, courseName, courseDuration, courseDescription)

        dbCourses.add(courses)
            .addOnSuccessListener {
                Toast.makeText(
                    context,
                    "Your Course has been added to Firebase Firestore",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "Fail to add course \n$e", Toast.LENGTH_SHORT).show()
            }
    }
}

enum class CourseDetailsActivity(context: Context, java: Any) {

}
