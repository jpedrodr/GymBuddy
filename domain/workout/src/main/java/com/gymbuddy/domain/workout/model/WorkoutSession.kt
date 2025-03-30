package com.gymbuddy.domain.workout.model

/**
 * Stores actual tracked workouts with timestamps.
 */
data class WorkoutSession(
    val id: String,
    val planId: String?, // Optional: Link to a WorkoutPlan if used
    val date: Long, // Timestamp of the session
    val exercises: List<ExerciseLog>, // Actual logged sets & reps
    val duration: Int // Total time spent
)