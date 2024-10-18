package at.htlhl.demoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.htlhl.demoapp.BottomBar
import at.htlhl.demoapp.data.User

@Composable
fun CalendarScreen(navController: NavController, user: User) {
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(top = 25.dp)
            .fillMaxSize()
    ) {
        // Other Stuff

        BottomBar(navController = navController)
    }
}