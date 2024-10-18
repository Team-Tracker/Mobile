package at.htlhl.demoapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.htlhl.demoapp.BottomBar
import at.htlhl.demoapp.R
import at.htlhl.demoapp.UserDataBox
import at.htlhl.demoapp.data.User

@Composable
fun ProfileScreen(navController: NavController, user: User) {
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(top = 25.dp)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
                .align(Alignment.CenterHorizontally)
                .padding(all = 5.dp),
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile"
        )

        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            UserDataBox(key = "Username:", value = user.getUserName())
            UserDataBox(key = "Firstname:", value = user.getFirstName())
            UserDataBox(key = "Lastname:", value = user.getLastName())
            UserDataBox(key = "Email:", value = user.getEmail())
            UserDataBox(key = "Phone number:", value = user.getPhone())

            Button(
                onClick = {
                    navController.navigate("login_screen")
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
                Text("Logout")
            }
        }

        BottomBar(navController = navController)
    }
}