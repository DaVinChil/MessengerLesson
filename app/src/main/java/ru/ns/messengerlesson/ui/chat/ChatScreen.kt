package ru.ns.messengerlesson.ui.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun Message(modifier: Modifier = Modifier, message: Message) {
    Column(
        modifier = modifier
            .width(200.dp)
            .background(color = Color(0x5019D8E1), shape = RoundedCornerShape(20.dp))
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Start),
            fontSize = 13.sp,
            text = message.sender.name,
            color = Color(0xFF0EB355),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                fontSize = 17.sp,
                text = message.message
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = Modifier,
                fontSize = 10.sp,
                text = formatDate(message.date)
            )
        }
    }
}

@SuppressLint("SimpleDateFormat")
fun formatDate(date: Date): String = SimpleDateFormat("hh:mm").format(date)

@Preview
@Composable
fun MessagePreview() {
    Message(
        message = Message(
            id = 1L,
            sender = UserDto("Tom"),
            message = "Hello everyone, my name is kotlin.",
            date = Date()
        )
    )
}