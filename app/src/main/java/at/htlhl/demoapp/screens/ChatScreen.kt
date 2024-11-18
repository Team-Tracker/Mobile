package at.htlhl.demoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.htlhl.demoapp.components.BottomBar
import at.htlhl.demoapp.data.User

@Composable
fun ChatScreen(navController: NavController, user: User) {
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        Button(onClick = { navController.navigate("single_chat_screen") }) {
            Text(text = "Test")
        }

        BottomBar(navController = navController)
    }
}