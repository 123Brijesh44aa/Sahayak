package com.sahayak.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sahayak.app.domain.model.HelpRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HelpRequestListScreen(
                        requests = fakeHelpRequests(),
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

fun fakeHelpRequests(): List<HelpRequest> = listOf(
    HelpRequest(1, "Need a maths tutor", "class 10 maths, weekends only", "Ravi"),
    HelpRequest(
        2,
        "Cycle pump needed",
        "just for 10 mins, tyre went flat near ghat road",
        "Anjali"
    ),
    HelpRequest(3, "Help moving a cupboard", "Need one more person, Saturday morning", "Brijesh")
)
