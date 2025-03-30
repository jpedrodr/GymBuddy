package com.gymbuddy.navigation

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
import com.gymbuddy.feature.home.HomeContent
import com.gymbuddy.feature.workout.ui.WorkoutListContentUI

@Composable
fun GymBuddyNavHost(navController: NavHostController, paddingValues: PaddingValues, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Destination.WORKOUTS.route,
        modifier = modifier
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        composable(Destination.HOME.route) {
            HomeContent()
        }
        composable(Destination.WORKOUTS.route) {
            WorkoutListContentUI()
        }
        composable(Destination.HISTORY.route) {
            HistoryContent()
        }
        composable(Destination.PROGRESS.route) {
            ProgressContent()
        }
        composable(Destination.PROFILE.route) {
            ProfileContent()
        }
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