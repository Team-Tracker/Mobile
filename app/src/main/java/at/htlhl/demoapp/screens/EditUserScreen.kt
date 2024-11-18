package at.htlhl.demoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.htlhl.demoapp.data.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditUserScreen(navController: NavController, user: User) {

    var newUsername: String by remember { mutableStateOf(user.getUsername()) }
    var newFirstName: String by remember { mutableStateOf(user.getFirstName()) }
    var newLastName: String by remember { mutableStateOf(user.getLastName()) }
    var newEmail: String by remember { mutableStateOf(user.getEmail()) }
    var newPhone: String by remember { mutableStateOf(user.getPhone()) }

    var newPassword: String by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = newUsername,
            onValueChange = { newText -> newUsername = newText },
            label = { Text("Username") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White
            ),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(percent = 15)
        )

        OutlinedTextField(
            value = newFirstName,
            onValueChange = { newText -> newFirstName = newText },
            label = { Text("Firstname") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White
            ),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(percent = 15)
        )

        OutlinedTextField(
            value = newLastName,
            onValueChange = { newText -> newLastName = newText },
            label = { Text("Lastname") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White
            ),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(percent = 15)
        )

        OutlinedTextField(
            value = newEmail,
            onValueChange = { newText -> newEmail = newText },
            label = { Text("Email") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White,
            ),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(percent = 15)
        )

        OutlinedTextField(
            value = newPhone,
            onValueChange = { newText -> newPhone = newText },
            label = { Text("Phone") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White
            ),
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(percent = 15)
        )

        Button(
            onClick = {
                navController.navigate("profile_screen")
                user.setUsername(newUsername)
                user.setFirstName(newFirstName)
                user.setLastName(newLastName)
                user.setEmail(newEmail)
                user.setPhone(newPhone)
            },
            colors = ButtonDefaults.buttonColors(
                Color.Blue
            ),
            modifier = Modifier
                .width(250.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(percent = 50)
        ) {
            Text("Confirm")
        }

        Button(
            onClick = {
                navController.navigate("profile_screen")
            },
            colors = ButtonDefaults.buttonColors(
                Color.Blue
            ),
            modifier = Modifier
                .width(250.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp),
            shape = RoundedCornerShape(percent = 50)
        ) {
            Text("Cancel")
        }
    }
}
