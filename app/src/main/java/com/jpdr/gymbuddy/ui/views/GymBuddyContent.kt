package com.jpdr.gymbuddy.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jpdr.gbcompose.GymBuddyTheme
import com.jpdr.gymbuddy.navigation.Destination
import com.jpdr.gymbuddy.navigation.GymBuddyNavHost

@Composable
fun GymBuddyContent() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { GymBuddyBottomBar(navController) }
    ) { innerPadding ->
        GymBuddyNavHost(navController, innerPadding)
    }
}

@Composable
fun GymBuddyBottomBar(
    navController: NavController
) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp,
    ) {
        val currentDestination =
            navController.currentBackStackEntryAsState().value?.destination?.route

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf(
                Destination.WORKOUTS,
                Destination.HISTORY,
                Destination.HOME,
                Destination.PROGRESS,
                Destination.PROFILE
            ).forEach { dest ->
                GymBuddyNavItem(
                    destination = dest,
                    isSelected = currentDestination == dest.route,
                    onClick = { navController.navigate(dest.route) }
                )
            }
        }
    }
}

@Composable
fun RowScope.GymBuddyNavItem(destination: Destination, isSelected: Boolean, onClick: () -> Unit) {
    val icon = when (destination) {
        Destination.HOME -> Icons.Filled.Home
        Destination.WORKOUTS -> Icons.Filled.Add
        Destination.HISTORY -> Icons.Filled.History
        Destination.PROFILE -> Icons.Filled.AccountCircle
        Destination.PROGRESS -> Icons.Filled.Timeline
    }

    val iconTint = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.outline
    }

    NavigationBarItem(
        icon = {
            Icon(
                imageVector = icon,
                tint = iconTint,
                contentDescription = destination.route
            )
        },
        selected = isSelected,
        onClick = onClick
    )
}

@Preview
@Composable
fun GymBuddyContentPreview() {
    GymBuddyTheme(
        darkTheme = false
    ) {
        GymBuddyContent()
    }
}

@Preview
@Composable
fun GymBuddyContentDarkModePreview() {
    GymBuddyTheme(
        darkTheme = true
    ) {
        GymBuddyContent()
    }
}