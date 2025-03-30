package com.gymbuddy.navigation

sealed class Destination(val route: String) {
    data object Home: Destination("home") //  Summary of progress, upcoming workouts, and achievements.
    data object WorkoutsList: Destination("workouts_list") // Log a new workout or follow saved routines.
    data object WorkoutSession: Destination("workout_session") // An actual workout session based on a workout plan
    data object History: Destination("history") // View past workouts, filter by date, type, etc.
    data object Progress: Destination("progress") // Visualize stats and track goals.
    data object Profile: Destination("profile")  // Manage profile, goals, reminders, and notifications.
}