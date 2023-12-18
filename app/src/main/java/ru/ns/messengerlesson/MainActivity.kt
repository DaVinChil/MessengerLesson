package ru.ns.messengerlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.ns.messengerlesson.ui.theme.MessengerLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatApp()
        }
    }
}

@Composable
fun ChatApp() {
    MessengerLessonTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding(),
            color = MaterialTheme.colorScheme.background
        ) {
        }
    }
}