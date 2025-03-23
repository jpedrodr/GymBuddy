package com.jpdr.gymbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jpdr.gbcompose.GymBuddyTheme
import com.jpdr.gymbuddy.ui.views.GymBuddyContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymBuddyTheme {
                GymBuddyContent()
            }
        }
    }
}
