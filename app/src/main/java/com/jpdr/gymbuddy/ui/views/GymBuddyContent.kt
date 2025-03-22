package com.jpdr.gymbuddy.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jpdr.gymbuddy.navigation.AppNavHost
import com.jpdr.gymbuddy.navigation.Destination

@Composable
fun GymBuddyContent() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { GymBuddyBottomBar(navController) }
    ) { innerPadding ->
        AppNavHost(navController, innerPadding)
    }
}

@Composable
fun GymBuddyBottomBar(
    navController: NavController
) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GymBuddyTab(navController, Destination.WORKOUTS)
            GymBuddyTab(navController, Destination.HISTORY)
            GymBuddyTab(navController, Destination.HOME)
            GymBuddyTab(navController, Destination.PROGRESS)
            GymBuddyTab(navController, Destination.PROFILE)
        }
    }
}

@Composable
fun GymBuddyTab(navController: NavController, destination: Destination) {
    IconButton(
        onClick = { navController.navigate(destination.route) }
    ) {
        val icon = when (destination) {
            Destination.HOME -> Icons.Filled.Home
            Destination.WORKOUTS -> Icons.Filled.Done
            Destination.HISTORY -> Icons.Filled.Add
            Destination.PROFILE -> Icons.Filled.ThumbUp
            Destination.PROGRESS -> Icons.Filled.AccountBox
        }

        val iconTint = if (navController.currentDestination?.route == destination.route) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurface
        }

        Icon(
            imageVector = icon,
            tint = iconTint,
            contentDescription = destination.route
        )
    }
}