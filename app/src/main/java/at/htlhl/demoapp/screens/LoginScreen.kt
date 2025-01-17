package at.htlhl.demoapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.htlhl.demoapp.R
import at.htlhl.demoapp.data.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, user: User) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val testUsername: String = "testUser"
    val testPW: String = ""

    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(20.dp)
            .fillMaxSize()
    ) {

        Image(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    color = Color(100,150,255),
                    shape = CircleShape
                ),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo"
        )

        OutlinedTextField(
            value = username,
            onValueChange = { newText -> username = newText },
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
                focusedIndicatorColor = Color.White
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
                      if(username == testUsername && testPW == password) {
                          user.setUsername(testUsername)
                          user.setPwHash(password)

                          navController.navigate("team_screen")
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
            Text("Login")
        }

        Button(
            onClick = {
                navController.navigate("registration_screen")
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
            Text("Create Account")
        }
    }
}