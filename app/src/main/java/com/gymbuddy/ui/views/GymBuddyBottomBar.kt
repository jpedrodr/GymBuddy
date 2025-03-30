package com.gymbuddy.ui.views

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
import androidx.compose.material3.FloatingActionButtonDefaults
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
import com.gymbuddy.gbcompose.preview.PreviewWithModes
import com.gymbuddy.gbcompose.theme.GymBuddyTheme
import com.gymbuddy.navigation.Destination
import com.gymbuddy.navigation.navigateTo
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

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
        val backstackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = remember(backstackEntry) {
            backstackEntry?.destination?.route
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf(
                Destination.Home,
                Destination.History,
                Destination.WorkoutsList,
                Destination.Progress,
                Destination.Profile
            ).forEach { dest ->
                GymBuddyNavItem(
                    destination = dest,
                    isSelected = currentDestination == dest.route,
                    onClick = { navController.navigateTo(dest) }
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
    if (destination == Destination.WorkoutsList) {
        val iconColor = MaterialTheme.colorScheme.onPrimary

        val containerColor = if (isSelected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onBackground
        }

        FloatingActionButton(
            containerColor = containerColor,
            elevation = FloatingActionButtonDefaults.loweredElevation(),
            contentColor = iconColor,
            onClick = onClick
        ) {
            Icon(
                imageVector = Icons.Filled.FitnessCenter,
                contentDescription = destination.route
            )
        }
    } else {
        val icon = when (destination) {
            Destination.Home -> Icons.Filled.Home
            Destination.WorkoutsList -> Icons.Filled.FitnessCenter
            Destination.History -> Icons.Filled.History
            Destination.Profile -> Icons.Filled.AccountCircle
            Destination.Progress -> Icons.Filled.Timeline
            else -> throw IllegalStateException("Destination $destination not supported in GymBuddyBottomBar")
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
