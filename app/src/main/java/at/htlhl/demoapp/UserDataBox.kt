package at.htlhl.demoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun UserDataBox(key: String, value: String) {
    Box(
        modifier = Modifier
            .padding(all = 5.dp)
            .border(
                width = 2.dp,
                color = Color.Black
            )
            .width(250.dp)
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(all = 3.dp)) {
            Text(text = key, style = TextStyle(textDecoration = TextDecoration.Underline))
            Text(text = value)
        }
    }
}