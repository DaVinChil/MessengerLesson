package ru.ns.messengerlesson.ui.chat

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ns.messengerlesson.data.remote.Message
import ru.ns.messengerlesson.data.remote.UserDto
import java.util.Date

@Composable
fun Message(modifier: Modifier = Modifier, message: Message) {
    Text(
        modifier = Modifier,
        fontSize = 13.sp,
        text = message.sender.name,
        color = Color(0xFF0EB355),
        fontWeight = FontWeight.Bold
    )
    Text(
        modifier = Modifier,
        fontSize = 17.sp,
        text = message.message
    )
    Spacer(modifier = Modifier.width(5.dp))
    Text(
        modifier = Modifier,
        fontSize = 10.sp,
        text = message.date.toString()
    )
}

@Preview
@Composable
fun MessagePreview() {
    Message(
        message = Message(
            id = 1L,
            sender = UserDto("Tom"),
            message = "Hello",
            date = Date()
        )
    )
}