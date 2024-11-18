package at.htlhl.demoapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import at.htlhl.demoapp.data.Message

@Composable
fun ChatBubble(message: Message, modifier: Modifier) {
    Box(modifier) {
        Text(text = message.getText())
    }
}
