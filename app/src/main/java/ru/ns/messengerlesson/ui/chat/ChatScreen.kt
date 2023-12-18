package ru.ns.messengerlesson.ui.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun ChatScreen(
    messages: List<Message>,
    onSendMessage: (String) -> Unit,
    isMineMessage: (Message) -> Boolean
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ChatContent(
            modifier = Modifier.weight(1f),
            messages = messages,
            isMineMessage = isMineMessage
        )
        InputMessage(onSendMessage = onSendMessage)
    }
}

@Composable
fun ChatContent(
    messages: List<Message>,
    isMineMessage: (Message) -> Boolean,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        items(
            count = messages.size,
            key = { messages[it].id }
        ) {
            val arrangement =
                if (isMineMessage(messages[it])) Arrangement.End else Arrangement.Start
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = arrangement
            ) {
                Message(message = messages[it])
            }
        }
    }
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputMessage(
    onSendMessage: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        var msg by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.weight(1f),
            value = msg,
            onValueChange = { msg = it },
            placeholder = {
                Text(text = "Enter a message")
            }
        )
        IconButton(
            onClick = {
                if (msg != "") {
                    onSendMessage(msg)
                    msg = ""
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                tint = Color(0xFF19D8E1),
                contentDescription = "send"
            )
        }
    }
}

@SuppressLint("SimpleDateFormat")
fun formatDate(date: Date): String = SimpleDateFormat("hh:mm").format(date)

@Preview
@Composable
fun ChatScreenPreview() {
    ChatScreen(
        messages = listOf(
            Message(
                id = 1L,
                sender = UserDto("Tom"),
                message = "Hello!",
                date = Date()
            ),
            Message(
                id = 2L,
                sender = UserDto("Tim"),
                message = "Hi, how are you?",
                date = Date()
            ),
            Message(
                id = 3L,
                sender = UserDto("Alex"),
                message = "-_-",
                date = Date()
            )
        ),
        onSendMessage = {},
        isMineMessage = { it.id == 2L }
    )
}

@Preview
@Composable
fun ChatContentPreview() {
    ChatContent(
        messages = listOf(
            Message(
                id = 1L,
                sender = UserDto("Tom"),
                message = "Hello!",
                date = Date()
            ),
            Message(
                id = 2L,
                sender = UserDto("Tim"),
                message = "Hi, how are you?",
                date = Date()
            ),
            Message(
                id = 3L,
                sender = UserDto("Alex"),
                message = "-_-",
                date = Date()
            )
        ),
        isMineMessage = { it.id == 2L }
    )
}

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

@Preview
@Composable
fun InputMessagePreview() {
    InputMessage(onSendMessage = {})
}