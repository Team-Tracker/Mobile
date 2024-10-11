package at.htlhl.demoapp

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavController) {
    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var repeatPW: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(25.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = email, onValueChange = { newText -> email = newText },
            label = { Text("Email Address") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                focusedLabelColor = Color.White,
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
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
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
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
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
                if (repeatPW == password && password.length >= 8) {
                    var user = User()

                    user.setEmail(email)
                    user.setPwHash(password)

                    navController.navigate("login_screen")
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color.Blue
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
                navController.navigate("login_Screen")
            },
            colors = ButtonDefaults.buttonColors(
                Color.Blue
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
