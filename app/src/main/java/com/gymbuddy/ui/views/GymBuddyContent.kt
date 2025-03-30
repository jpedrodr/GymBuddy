package com.gymbuddy.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gymbuddy.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme
import com.gymbuddy.navigation.Destination
import com.gymbuddy.navigation.GymBuddyNavHost

@Composable
fun GymBuddyContent() {
    val navController = rememberNavController()

    val currentDestination by navController.currentBackStackEntryAsState()

    val isBottomBarVisible = remember(currentDestination) {
        when (currentDestination?.destination?.route ?: "") {
            Destination.WorkoutSession.ROUTE -> false
            else -> true
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                GymBuddyBottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        GymBuddyNavHost(
            navController = navController,
            paddingValues = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
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
