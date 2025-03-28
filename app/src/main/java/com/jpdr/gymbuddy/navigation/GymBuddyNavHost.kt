package com.jpdr.gymbuddy.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jpdr.features.home.HomeContent

@Composable
fun GymBuddyNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = Destination.HOME.route) {
        composable(Destination.HOME.route) {
            HomeContent(modifier = Modifier.padding(paddingValues).padding(16.dp))
        }
        composable(Destination.WORKOUTS.route) {
            WorkoutsContent(modifier = Modifier.padding(paddingValues).padding(16.dp))
        }
        composable(Destination.HISTORY.route) {
            HistoryContent(modifier = Modifier.padding(paddingValues).padding(16.dp))
        }
        composable(Destination.PROGRESS.route) {
            ProgressContent(modifier = Modifier.padding(paddingValues).padding(16.dp))
        }
        composable(Destination.PROFILE.route) {
            ProfileContent(modifier = Modifier.padding(paddingValues).padding(16.dp))
        }
    }
}

@Composable
fun WorkoutsContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text("WORKOUTS")
        Text("Log a new workout or follow saved routines.")
    }
}

@Composable
fun HistoryContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text("HISTORY")
        Text("View past workouts, filter by date, type, etc.")
    }
}

@Composable
fun ProgressContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text("PROGRESS")
        Text("Visualize stats and track goals.")
    }
}

@Composable
fun ProfileContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text("PROFILE")
        Text("Manage profile, goals, reminders, and notifications.")
    }
}