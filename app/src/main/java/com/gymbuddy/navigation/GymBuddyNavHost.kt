package com.gymbuddy.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gymbuddy.feature.home.HomeContent
import com.gymbuddy.feature.workout.ui.list.WorkoutListContentUI
import com.gymbuddy.feature.workout.ui.session.WorkoutSessionContentUI
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
        topLevelRoutes(navController = navController)

        composable(
            route = WorkoutSession.ROUTE,
            arguments = listOf(navArgument(WorkoutSession.WORKOUT_PLAN_ID) {
                type = NavType.StringType
            }),
            enterTransition = { fadeIn() + slideInVertically(initialOffsetY = { it }) },
            exitTransition = { fadeOut() + slideOutVertically(targetOffsetY = { it }) }
        ) { backStackEntry ->
            val workoutPlanId = backStackEntry.arguments?.getString(WorkoutSession.WORKOUT_PLAN_ID)
            if (workoutPlanId != null) {
                WorkoutSessionContentUI(workoutPlanId = workoutPlanId)
            }
        }
    }
}

/**
 * The high level routes of the app, the ones accessible from the bottom bart
 */
private fun NavGraphBuilder.topLevelRoutes(navController: NavHostController) {
    composable(Destination.Home.route) {
        HomeContent()
    }

    composable(Destination.WorkoutsList.route) {
        WorkoutListContentUI(navController = navController)
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