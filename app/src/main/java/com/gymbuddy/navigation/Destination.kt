package com.gymbuddy.navigation

sealed class Destination(val route: String) {
    object HOME: Destination("home") //  Summary of progress, upcoming workouts, and achievements.
    object WORKOUTS: Destination("workouts") // Log a new workout or follow saved routines.
    object HISTORY: Destination("history") // View past workouts, filter by date, type, etc.
    object PROGRESS: Destination("progress") // Visualize stats and track goals.
    object PROFILE: Destination("profile")  // Manage profile, goals, reminders, and notifications.
}