package com.gymbuddy.navigation

import androidx.navigation.NavController

sealed class Destination(val route: String) {
    // Summary of progress, upcoming workouts, and achievements.
    data object Home : Destination("home")

    // Log a new workout or follow saved routines.
    data object WorkoutsList : Destination("workouts/list")

    // An actual workout session based on a workout plan
    data class WorkoutSession(val workoutPlanId: String) :
        Destination("$BASE_ROUTE/$workoutPlanId") {
        companion object {
            const val BASE_ROUTE = "workout/session"
            const val WORKOUT_PLAN_ID = "workoutPlanId"
        }
    }

    // View past workouts, filter by date, type, etc.
    data object History : Destination("history")

    // Visualize stats and track goals.
    data object Progress : Destination("progress")

    // Manage profile, goals, reminders, and notifications.
    data object Profile : Destination("profile")
}

fun NavController.navigateTo(destination: Destination) {
    navigate(destination.route)
}