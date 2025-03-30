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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gymbuddy.feature.home.HomeContent
import com.gymbuddy.feature.workout.ui.WorkoutListContentUI
import com.gymbuddy.feature.workout.ui.WorkoutSessionContentUI
import com.gymbuddy.navigation.Destination.WorkoutSession

@Composable
fun GymBuddyNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destination.WorkoutsList.route,
        modifier = modifier
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        composable(Destination.Home.route) {
            HomeContent()
        }

        composable(Destination.WorkoutsList.route) {
            WorkoutListContentUI(navController = navController)
        }

        composable(
            route = "${WorkoutSession.BASE_ROUTE}/{${WorkoutSession.WORKOUT_PLAN_ID}}",
            arguments = listOf(navArgument(WorkoutSession.WORKOUT_PLAN_ID) { type = NavType.StringType })
        ) { backStackEntry ->
            val workoutPlanId = backStackEntry.arguments?.getString(WorkoutSession.WORKOUT_PLAN_ID)
            println("joaorosa | workoutPlanId from route is $workoutPlanId")
            // joaorosa test this
            if (workoutPlanId != null) {
                WorkoutSessionContentUI(workoutPlanId = workoutPlanId)
            }
        }

        composable(Destination.History.route) {
            HistoryContent()
        }

        composable(Destination.Progress.route) {
            ProgressContent()
        }

        composable(Destination.Profile.route) {
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