package com.gymbuddy.gymbuddy.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gymbuddy.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme
import com.gymbuddy.gymbuddy.navigation.GymBuddyNavHost
import com.gymbuddy.ui.views.GymBuddyBottomBar

@Composable
fun GymBuddyContent() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { GymBuddyBottomBar(navController) }
    ) { innerPadding ->
        GymBuddyNavHost(
            navController = navController,
            paddingValues = innerPadding,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@PreviewWithModes
@Composable
fun GymBuddyContentPreview() {
    GymBuddyTheme {
        GymBuddyContent()
    }
}
