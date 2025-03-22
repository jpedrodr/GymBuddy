package com.jpdr.gymbuddy.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = Destination.HOME.route) {
        composable(Destination.HOME.route) {
            HomeContent(modifier = Modifier.padding(paddingValues))
        }
        composable(Destination.WORKOUTS.route) {
            WorkoutsContent(modifier = Modifier.padding(paddingValues))
        }
        composable(Destination.HISTORY.route) {
            HistoryContent(modifier = Modifier.padding(paddingValues))
        }
        composable(Destination.PROGRESS.route) {
            ProgressContent(modifier = Modifier.padding(paddingValues))
        }
        composable(Destination.PROFILE.route) {
            ProfileContent(modifier = Modifier.padding(paddingValues))
        }
    }
}

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("HOME")
    }
}

@Composable
fun WorkoutsContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("WORKOUTS")
    }
}

@Composable
fun HistoryContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("HISTORY")
    }
}

@Composable
fun ProgressContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("PROGRESS")
    }
}

@Composable
fun ProfileContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("PROFILE")
    }
}