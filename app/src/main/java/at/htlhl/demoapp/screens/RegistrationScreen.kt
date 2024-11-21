package at.htlhl.demoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.htlhl.demoapp.data.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavController, user: User) {
    var username: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var repeatPW: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(20.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = username, onValueChange = { newText -> username = newText },
            label = { Text("Username") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White
            ),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp, top = 20.dp),
            shape = RoundedCornerShape(percent = 15)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { newText -> password = newText },
            label = { Text("Password") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White
            ),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(percent = 15),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        OutlinedTextField(
            value = repeatPW,
            onValueChange = { newText -> repeatPW = newText },
            label = { Text("Repeat Password") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White
            ),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(percent = 15),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        Button(
            onClick = {
                var error: String = ""

                when (checkPW(password, repeatPW)) {
                    0 -> {
                        user.setEmail(username)
                        user.setPwHash(password)

                        // Daten an Backend senden

                        navController.navigate("login_screen")
                    }

                    1 -> {
                        error = "Password is too short"
                    }

                    2 -> {
                        error = "Password is missing uppercase letter"
                    }

                    3 -> {
                        error = "Password is missing lowercase letter"
                    }

                    4 -> {
                        error = "Password is missing number"
                    }

                    5 -> {
                        error = "Passwords do not match"
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color(100,150,255)
            ),
            modifier = Modifier
                .width(250.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(percent = 50)
        ) {
            Text("Register")
        }

        Button(
            onClick = {
                navController.navigate("login_screen")
            },
            colors = ButtonDefaults.buttonColors(
                Color(100,150,255)
            ),
            modifier = Modifier
                .width(250.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(percent = 50)
        ) {
            Text("Back")
        }
    }
}

fun checkPW(password: String, repeatPW: String): Number {
    val uppercase = Regex(".*[A-Z].*")
    val lowercase = Regex(".*[a-z].*")
    val number = Regex(".*[0-9].*")

    if (password.length < 8) {
        // Password is too short
        return 1
    }

    if (!uppercase.matches(password)) {
        // Password is missing uppercase letter
        return 2
    }

    if (!lowercase.matches(password)) {
        // Password is missing lowercase letter
        return 3
    }

    if (!number.matches(password)) {
        // Password is missing number
        return 4
    }

    if (password != repeatPW) {
        // Passwords do not match
        return 5
    }

    // Password is valid
    return 0
}
