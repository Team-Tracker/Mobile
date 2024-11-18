package at.htlhl.demoapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.htlhl.demoapp.components.ChatBubble
import at.htlhl.demoapp.data.Chat
import at.htlhl.demoapp.data.User

var modifierReceiver: Modifier = Modifier
    .background(Color(0, 0, 255))
    .clip(shape = RoundedCornerShape(10.dp))

var modifierSender: Modifier = Modifier
    .background(Color(255, 127, 0))
    .clip(shape = RoundedCornerShape(10.dp))


@Composable
fun SingleChatScreen(navController: NavController, user: User, chat: Chat) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(Color(50, 50, 50))
                .border(width = 1.dp, color = Color.Black)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.Top
            ) {
                Button(
                    shape = RectangleShape,
                    onClick = { navController.navigate("chat_screen") },
                    colors = ButtonDefaults.buttonColors(Color(50, 50, 50))

                ) {
                    Text(text = "Back")
                }
                Text(text = chat.getName())
            }
        }
    }


    // loop through messages in one chat
    for (message in chat.getMessages()) {
        if (message.getSender().getUsername() == user.getUsername()) {
            ChatBubble(message = message, modifier = modifierSender)
        } else {
            ChatBubble(message = message, modifier = modifierReceiver)
        }
    }
}
