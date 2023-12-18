package ru.ns.messengerlesson.ui.register

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    var username by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.fillMaxWidth(0.5f),
        value = username,
        onValueChange = { username = it },
        placeholder = { Text(text = "Enter username") }
    )
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}