package com.gymbuddy.navigation

sealed class Destination(val route: String) {
    data object HOME: Destination("home") //  Summary of progress, upcoming workouts, and achievements.
    data object WORKOUTS: Destination("workouts") // Log a new workout or follow saved routines.
    data object HISTORY: Destination("history") // View past workouts, filter by date, type, etc.
    data object PROGRESS: Destination("progress") // Visualize stats and track goals.
    data object PROFILE: Destination("profile")  // Manage profile, goals, reminders, and notifications.
}