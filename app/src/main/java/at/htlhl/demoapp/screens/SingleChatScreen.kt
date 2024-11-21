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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import at.htlhl.demoapp.components.ChatBar
import at.htlhl.demoapp.components.ChatBubble
import at.htlhl.demoapp.data.Chat
import at.htlhl.demoapp.data.Date
import at.htlhl.demoapp.data.Message
import at.htlhl.demoapp.data.User


// ToDo alignment
var modifierReceiver: Modifier = Modifier
    .padding(all = 5.dp)
    .clip(shape = RoundedCornerShape(15))
    .background(Color(100, 150, 255))
    .width(300.dp)
    .padding(all = 5.dp)

var modifierSender: Modifier = Modifier
    .padding(all = 5.dp)
    .clip(shape = RoundedCornerShape(15))
    .background(Color(255, 127, 0))
    .width(300.dp)
    .padding(all = 5.dp)

@Composable
fun SingleChatScreen(navController: NavController, user: User) {

    var demoChat = Chat()

    demoChat.setName("DemoChat")

    demoChat.addMessage(Message(0, User(), "Message1", Date()))
    demoChat.addMessage(Message(0, user, "Message2", Date()))
    demoChat.addMessage(Message(0, User(), "Message3", Date()))
    demoChat.addMessage(Message(0, user, "Message4", Date()))
    demoChat.addMessage(Message(0, user, "Message5", Date()))
    demoChat.addMessage(Message(0, user, "Message6", Date()))
    demoChat.addMessage(Message(0, user, "Message7", Date()))
    demoChat.addMessage(Message(0, user, "Message8", Date()))
    demoChat.addMessage(Message(0, user, "Message9", Date()))
    demoChat.addMessage(Message(0, user, "Message10", Date()))
    demoChat.addMessage(Message(0, user, "Message11", Date()))
    demoChat.addMessage(Message(0, user, "Message12", Date()))
    demoChat.addMessage(Message(0, user, "Message13", Date()))
    demoChat.addMessage(Message(0, user, "Message14", Date()))

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
                    onClick = {
                        navController.navigate("chat_screen")
                    },
                    colors = ButtonDefaults.buttonColors(Color(50, 50, 50))

                ) {
                    Text(text = "Back")
                }
                Text(
                    text = demoChat.getName(),
                    Modifier
                        .padding(top = 10.dp)
                        .padding(start = 90.dp),
                    color = Color.White
                )
            }
        }

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (message in demoChat.getMessages()) {
                if (message.getSender().getUsername() == user.getUsername()) {
                    ChatBubble(message = message, modifier = modifierSender)
                } else {
                    ChatBubble(message = message, modifier = modifierReceiver)
                }
            }
        }

        ChatBar()
    }
}
