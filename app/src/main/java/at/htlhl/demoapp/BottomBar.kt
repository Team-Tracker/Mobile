package at.htlhl.demoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = { navController.navigate("team_screen") },
            Modifier.weight(0.25f),
            colors = ButtonDefaults.buttonColors(
                Color.Blue
            ),
            shape = RoundedCornerShape(0)
        ) {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                painter = painterResource(id = R.drawable.team),
                contentDescription = "Team"
            )
        }
        Button(
            onClick = { navController.navigate("calendar_screen") },
            Modifier.weight(0.25f),
            colors = ButtonDefaults.buttonColors(
                Color.Blue
            ),
            shape = RoundedCornerShape(0)
        ) {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = "Calendar"
            )

        }
        Button(
            onClick = { navController.navigate("chat_screen") },
            Modifier.weight(0.25f),
            colors = ButtonDefaults.buttonColors(
                Color.Blue
            ),
            shape = RoundedCornerShape(0)
        ) {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                painter = painterResource(id = R.drawable.chat),
                contentDescription = "Chat"
            )
        }
        Button(
            onClick = { navController.navigate("profile_screen") },
            Modifier.weight(0.25f),
            colors = ButtonDefaults.buttonColors(
                Color.Blue
            ),
            shape = RoundedCornerShape(0)
        ) {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile"
            )
        }
    }
}
