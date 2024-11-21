package at.htlhl.demoapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import at.htlhl.demoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatBar() {
    var text by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        OutlinedTextField(
            value = text,
            modifier = Modifier.width(340.dp),
            onValueChange = { newText -> text = newText },
            label = { Text("Message") },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.White
            ),
            shape = RectangleShape
        )
        Button(
            onClick = {
                // build new Message() and send
            },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                Color(100,150,255)
            )
        ) {
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                painter = painterResource(id = R.drawable.sendarrow),
                contentDescription = "Send"
            )
        }
    }
}