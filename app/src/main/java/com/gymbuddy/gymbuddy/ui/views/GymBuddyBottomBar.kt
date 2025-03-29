package com.jpdr.gymbuddy.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jpdr.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme
import com.jpdr.gymbuddy.navigation.Destination

@Composable
fun GymBuddyBottomBar(
    navController: NavController
) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    ) {
        val currentDestination =
            navController.currentBackStackEntryAsState().value?.destination?.route

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf(
                Destination.HOME,
                Destination.HISTORY,
                Destination.WORKOUTS,
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
private fun GymBuddyNavItem(
    destination: Destination,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    if (destination == Destination.WORKOUTS) {
        val iconTint = if (isSelected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.background
        }

        FloatingActionButton(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = iconTint,
            onClick = onClick
        ) {
            Icon(Icons.Filled.FitnessCenter, destination.route)
        }
    } else {
        val icon = when (destination) {
            Destination.HOME -> Icons.Filled.Home
            Destination.WORKOUTS -> Icons.Filled.FitnessCenter
            Destination.HISTORY -> Icons.Filled.History
            Destination.PROFILE -> Icons.Filled.AccountCircle
            Destination.PROGRESS -> Icons.Filled.Timeline
        }

        val iconTint = if (isSelected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurface
        }

        IconButton(
            onClick = onClick
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = icon,
                tint = iconTint,
                contentDescription = destination.route
            )
        }
    }
}

@PreviewWithModes
@Composable
fun GymBuddyBottomBarPreview() {
    GymBuddyTheme {
        GymBuddyBottomBar(rememberNavController())
    }
}
