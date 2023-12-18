package ru.ns.messengerlesson.ui.chat

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.ns.messengerlesson.data.remote.Message

@Composable
fun Message(modifier: Modifier = Modifier, message: Message) {
    Text(
        modifier = Modifier,
        fontSize = 13.sp,
        text = message.sender.name,
        color = Color(0xFF0EB355),
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
fun MessagePreview() {

}